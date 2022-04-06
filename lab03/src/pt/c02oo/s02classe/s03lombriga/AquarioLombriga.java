package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
    int s_aqua;
    int s_lomb;
    int pos;
    String lado;
    
    AquarioLombriga(int s_aqua, int s_lomb, int pos) {
        this.s_aqua = s_aqua;
        this.s_lomb = s_lomb;
        this.pos = pos;
        this.lado = "esquerda";
        
        if (this.s_aqua < this.s_lomb) {
        	this.s_lomb = this.s_aqua; //Correcao de tamanho em excesso.
        }
        
        if (this.pos < 1 || this.pos > this.s_aqua || (this.pos + this.s_lomb - 1) > s_aqua) {
        	this.pos = 1; //Correcao de posicao invalida.
        }
    }
    
    public void crescer() {
    	if (lado.equals("esquerda") == true) {
    		if (pos + s_lomb - 1 < s_aqua) {
    			this.s_lomb += 1;
    		}
    	}
    	
    	else {
    		if (pos - s_lomb + 1 > 1) {
    			this.s_lomb += 1;
    		}
    	}
    }
    
    public void mover() {
    	if (lado.equals("esquerda") == true) {
    		if (pos == 1) {
    			this.virar();
    		}
    		
    		else {
    			this.pos -= 1;
    		}
    	}
    	
    	else {
    		if (pos == s_aqua) {
    			this.virar();
    		}
    		
    		else {
    			this.pos += 1;
    		}
    	}
    }
    
    public void virar() {
    	if (lado.equals("esquerda") == true) {
    		this.pos = pos + s_lomb - 1;
    		this.lado = "direita";
    	}
    	
    	else {
    		this.pos = pos - s_lomb + 1;
    		this.lado = "esquerda";
    	}
    }
    
    public String apresentar() {
    	String resultado = "";
    	int i = 1;
    	
    	while (i <= s_aqua) {
    		if (lado.equals("esquerda") == true) {
    			if (i < pos || i > pos + s_lomb - 1) {
    				resultado += "#";
    				i += 1;
    			}
    			
    			else {
    				for (int j = pos; j <= pos + s_lomb - 1; j++) {
    					if (i == pos) {
    		    			resultado += "O";
    		    		}
    					
    					else {
        					resultado += "@";
    					}
    					i += 1;
    				}
    			}
    		}
    		
    		else {
    			if (i < pos - s_lomb + 1 || i > pos) {
    				resultado += "#";
    				i += 1;
    			}
    			
    			else {
    				for (int j = pos - s_lomb + 1; j <= pos; j++) {
    					if (i == pos) {
    		    			resultado += "O";
    		    		}
    					
    					else {
        					resultado += "@";
    					}
    					i += 1;
    				}
    			}
    			
    			
    		}
    	}
    	
    	return resultado;
    }
}

