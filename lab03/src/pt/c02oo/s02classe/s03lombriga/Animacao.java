package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	String comandos;
	int n_comandos;
	int n_passos;
	AquarioLombriga lomb;
	
	Animacao(String entrada) {
		int s_aqua = Integer.parseInt(entrada.substring(0, 2));
		int s_lomb = Integer.parseInt(entrada.substring(2, 4));
		int pos = Integer.parseInt(entrada.substring(4, 6));
		this.comandos = entrada.substring(6);
		this.n_comandos = this.comandos.length();
		this.n_passos = 0;
		
		lomb = new AquarioLombriga(s_aqua, s_lomb, pos);
	}
	
	public void passo() {
		if (this.comandos.charAt(n_passos) == 'M') {
			this.lomb.mover();
		}
		
		else if (this.comandos.charAt(n_passos) == 'C') {
			this.lomb.crescer();
		}
		
		if (this.comandos.charAt(n_passos) == 'V') {
			this.lomb.virar();
		}
		
		this.n_passos += 1;
	}
	
	public String apresentar() {
		String resultado = this.lomb.apresentar();
		return resultado;
	}
}

