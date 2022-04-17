package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	private Peca tabuleiro[][];
	
	public Tabuleiro() { 
		//A montagem do tabuleiro, sendo uma matriz de pecas, ocorre na funcao principal.
		tabuleiro = new Peca[7][7];
	}
	
	public void adicionarPeca(int linha, int coluna, Peca peca) {
		tabuleiro[linha][coluna] = peca;
	}
	
	public void removerPeca(int linha, int coluna) {
		tabuleiro[linha][coluna].setVazio(1);
	}
	
	public Peca[][] getTabuleiro() {
		return tabuleiro;
	}
	
	public int[] getCommandPos(String coord) {
		/*
		 * Traduz uma combinacao de letra e numero em uma vetor de coordenadas.
		 * Retorna esse vetor.
		 */
		
		int pos[] = new int[2];
		
		pos[1] = coord.charAt(0) - 97;
		pos[0] = coord.charAt(1) - 49; //-48 pela tabela ASCII, -1 por ser um a mais que o índice procurado.
		
		return pos;
	}
	
	public int mover(String sourcePosString, String targetPosString) {
		/*
		 * Recebe uma posicao inicial (source) e uma final (target).
		 * Calcula todas as posicoes possiveis para a peca atraves de uma matriz especial.
		 * O primeiro indice da matriz guarda as direcoes em relacao a peca (esquerda, direita, cima, baixo).
		 * O segundo indice guarda informacoes da peca adjacente a peca e da peca depois da adjacente.
		 * O terceiro indice guarda a posicao de uma peca, seja ela a adjacente ou a logo apos esta, e se ela esta vazia (1) ou nao (0).
		 * Essa matriz eh repassada para a peca junto com as coordenadas do target.
		 * O que a peca retorna eh analisado. Se o movimento e valido, o tabuleiro move e remove as pecas adequadas e retorna 1.
		 * Retorna 0 se o source for nulo (fora do tabuleiro) ou se a movimentacao nao e valida.
		 */
		
		int sourcePos[] = getCommandPos(sourcePosString);
		int targetPos[] = getCommandPos(targetPosString);
		
		Peca source = tabuleiro[sourcePos[0]][sourcePos[1]];
		
		if (source == null) {
			return 0;
		}
		
		int posValidas[][][] = new int[4][2][3];
		int resultados[][] = new int[2][2];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= 1; j++) {
				switch(i) {
				case 0: //esquerda
					if (sourcePos[1]-(j+1) < 0) {
						posValidas[i][j] = null;
					}
					
					else if (tabuleiro[sourcePos[0]][sourcePos[1]-(j+1)] == null) {
						posValidas[i][j] = null;
					}
										
					else {
						posValidas[i][j] = tabuleiro[sourcePos[0]][sourcePos[1]-(j+1)].getPeca();
					}
					break;
				case 1: //direita
					if (sourcePos[1]+(j+1) > 6) {
						posValidas[i][j] = null;
					}
					
					else if (tabuleiro[sourcePos[0]][sourcePos[1]+(j+1)] == null) {
						posValidas[i][j] = null;
					}
					
					else {
						posValidas[i][j] = tabuleiro[sourcePos[0]][sourcePos[1]+(j+1)].getPeca();
					}
					break;
				case 2: //cima
					if (sourcePos[0]-(j+1) < 0) {
						
					}
					
					
					else if (tabuleiro[sourcePos[0]-(j+1)][sourcePos[1]] == null) {
						posValidas[i][j] = null;
					}
					
					else {
						posValidas[i][j] = tabuleiro[sourcePos[0]-(j+1)][sourcePos[1]].getPeca();
					}
					break;
				case 3: //baixo
					if (sourcePos[0]+(j+1) > 6) {
						posValidas[i][j] = null;

					}
					
					else if (tabuleiro[sourcePos[0]+(j+1)][sourcePos[1]] == null) {
						posValidas[i][j] = null;
					}
					
					else {
						posValidas[i][j] = tabuleiro[sourcePos[0]+(j+1)][sourcePos[1]].getPeca();
					}
					break;
				}
			}
		}
		
		resultados = source.getPossivel(posValidas, targetPos);
		
		if (resultados[0][0] != -1) { //-1 = movimentacao nao valida
			removerPeca(sourcePos[0], sourcePos[1]);
			removerPeca(resultados[0][0],resultados[0][1]);
			tabuleiro[resultados[1][0]][resultados[1][1]].setVazio(0);
			
			return 1;
		}
		
		return 0;
	}
	
	public char[][] retornarTabuleiro() {
		//Retorna o tabuleiro na forma formatada, com Ps e -s nas posicoes corretas.
		char representacao[][] = new char[7][7];
		
		for (int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				if (tabuleiro[i][j] == null) {
					representacao[i][j] = ' ';
				}
				
				else if (tabuleiro[i][j].getVazio() == 1) {
					representacao[i][j] = '-';
				}
				
				else {
					representacao[i][j] = 'P';
				}
			}
		}
		
		return representacao;
	}
}
