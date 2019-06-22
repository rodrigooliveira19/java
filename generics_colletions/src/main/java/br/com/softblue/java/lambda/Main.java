package br.com.softblue.java.lambda;

public class Main {

	public static void main(String[] args) {
		
		
		Calculator cal = e -> {
			e = e * 10;
			System.out.println(e);
		};
		
		CalculatorTwo calTwo = (x,y) -> {
			System.out.println(x * y);
		}; 
		
		//SE N�O UTILIZAR CHAVES N�O � NECESS�RIO COLOCAR O RETURN 
		CalculatorComReturn calcR = p -> p * p; 
		
		cal.calculate(20);
		calTwo.calculate(10, 12);
		System.out.println(calcR.calculate(9));
	}

}
