package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      Animacao lombriga;
      
      for (int l = 0; l < lombrigas.length; l++) {
    	  lombriga = new Animacao(lombrigas[l]);
    	  tk.gravaPasso("=====");
    	  for (int i = lombriga.n_comandos; i > 0; i--) {
    		  if (i == lombriga.n_comandos) {
    			  tk.gravaPasso(lombriga.apresentar());
    		  }
    		  lombriga.passo();
    		  tk.gravaPasso(lombriga.apresentar());
    	  }
      }
      tk.stop();
   }
}

