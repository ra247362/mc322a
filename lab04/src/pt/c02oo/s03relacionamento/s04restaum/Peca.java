package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	private int pos[];
	private int vazio = 0; //1 = espaco vazio; 0 = preenchido;
	
	Peca(int lin, int col, int vazio) {
		pos = new int[2];
		pos[0] = lin;
		pos[1] = col;
		this.vazio = vazio;
	}
	
	public int[] getPeca() {
		int peca[] = new int[3];
		
		peca[0] = this.pos[0];
		peca[1] = this.pos[1];
		peca[2] = this.vazio;

		return peca;
	}
	
	public int[] getPos() {
		return this.pos;
	}
	
	public void setVazio(int vazio) {
		this.vazio = vazio;
	}
	
	public int getVazio() {
		return vazio;
	}
	
	public int[][] getPossivel(int[][][] posValidas, int[] targetPos) {
		/*
		 * Recebe uma matriz de posicoes validas do tabuleiro e as coordenadas de uma posicao final.
		 * Avalia, dada as regras do Resta Um, se a posicao alvo e uma das posicoes possiveis e se o salto eh possivel.
		 * Caso sim, retorna uma matriz contendo informacoes da posicao alvo e da peca entre a posicao alvo e a peca de origem.
		 * Caso nao, retorna uma matriz com posicoes todas -1, indicando que nao eh possivel realizar a movimentacao.
		 */
		int resultados[][] = new int [2][2];
		
		resultados[0][0] = -1;
		resultados[0][1] = -1;
		resultados[1][0] = -1;
		resultados[1][1] = -1;

		for (int i = 0; i < 4; i++) {
			if (posValidas[i][1] != null) {
				if (posValidas[i][1][0] == targetPos[0] && posValidas[i][1][1] == targetPos[1] && posValidas[i][1][2] == 1) {
					if (posValidas[i][0] != null) {
						if (posValidas[i][0][2] == 0) {
							resultados[0][0] = posValidas[i][0][0];
							resultados[0][1] = posValidas[i][0][1];
							resultados[1][0] = posValidas[i][1][0];
							resultados[1][1] = posValidas[i][1][1];
							return resultados;
						}
					}
				}
			}
		}
		return resultados;
	}
}
