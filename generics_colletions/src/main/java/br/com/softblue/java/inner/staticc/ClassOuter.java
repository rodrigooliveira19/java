package br.com.softblue.java.inner.staticc;

public class ClassOuter {
	
	public static class ClassInner {
		
		private int x = 10; 
		
		public void imprimir() {
			System.out.println("Valor "+this.x);
		}
	}

}
