package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
      Tabuleiro tabuleiro = new Tabuleiro();

      for (int i = 0; i < 7; i++) {
    	  for(int j = 0; j < 7; j++) {
    		  if ((i > 1 && i < 5) || (j > 1 && j < 5)) {
    			  Peca temp = new Peca(i, j, 0);
    			  if (i == 3 && j == 3) {
    				  temp.setVazio(1);
    				  tabuleiro.adicionarPeca(i, j, temp);
    			  }

    			  else {
    				  tabuleiro.adicionarPeca(i, j, temp);			
    			  }
    			 
    		  }
				
    		  else {
    			  tabuleiro.adicionarPeca(i, j, null);				
    		  }
    	  }
      }
      
      tk.writeBoard("Tabuleiro inicial", tabuleiro.retornarTabuleiro());
      
      for (int l = 0; l < commands.length; l++) {
    	  String coords[] = commands[l].split(":");
    	  String titulo = "source: " + coords[0] + "; target: " + coords[1];
          int valido = tabuleiro.mover(coords[0], coords[1]);
          
          if (valido == 1) {
              tk.writeBoard(titulo, tabuleiro.retornarTabuleiro());
          }
      }
      
      tk.stop();
   }
}