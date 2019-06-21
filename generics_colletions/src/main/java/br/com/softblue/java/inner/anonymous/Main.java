package br.com.softblue.java.inner.anonymous;

public class Main {

	public static void main(String[] args) {
		
		final  String qtd = "10 bebidas"; 
		
		Bebida bebida = new Bebida() {
			
			public void prepara() {
				System.out.println("Bebida anonoma......."+ qtd);
				
			}
		};
		
		bebida.prepara();
	}

}
