package br.com.softblue.java.inner;

public class Main {

	public static void main(String[] args) {
		
		Calculadora calc = new Calculadora(); 
		calc.setValor1(10);
		calc.setValor2(15);
		
		System.out.println("Resultado : "+calc.somar());

	}

}
