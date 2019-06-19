package br.com.softblue.java.inner;

public class Calculadora {
	
	private int valor1; 
	private int valor2;
	private int resultado; 
	
	private class Somar {
		public void executar() {
			Calculadora.this.resultado = Calculadora.this.valor1 + Calculadora.this.valor2; 
		}
	}
	
	public int getValor1() {
		return valor1;
	}
	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}
	public int getValor2() {
		return valor2;
	}
	public void setValor2(int valor2) {
		this.valor2 = valor2;
	} 
	
	public int somar() {
		Somar somar = new Somar(); 
		somar.executar();
		return this.resultado; 
		
	}
	
	
	
	

}
