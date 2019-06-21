package br.com.softblue.java.inner.staticc;

public class ClassOuter {
	
	private static int z = 50; 
	
	public static void verificarAcesso() {
		System.out.println("Tenho acesso");
	}
	
	public static class ClassInner {
		
		private int x = 10; 
		
		//NÃO ACESSA OS ATRIBUTOS DIRETAMENTE, MAS TEM ACESSO A MÉTODOS E ATRIBUTOS ESTATICOS. 
		public void imprimir() {
			System.out.println("Valor "+z);
			ClassOuter.z+=1;
			System.out.println("Valor "+z);
		}
	}

}
