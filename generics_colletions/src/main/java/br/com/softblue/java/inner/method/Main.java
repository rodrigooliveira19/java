package br.com.softblue.java.inner.method;

public class Main {

	public static void main(String[] args) {
		
		final String t2 = "Variavel do metodo"; 
		
		class Texto {
			
			private String t; 
			
			public Texto(String t) {
				this.t = t; 
			}
			
			public void getTexto2() {
				System.out.println(t2);
			}
			
			public void imprimir() {
				System.out.println(this.t);
			}
		}
		
		Texto  txt = new Texto("Classe dentro de metodo"); 
		txt.imprimir();
		txt.getTexto2(); 

	}

}
