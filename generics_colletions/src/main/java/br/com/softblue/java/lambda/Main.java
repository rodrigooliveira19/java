package br.com.softblue.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		
		Calculator cal = e -> {
			e = e * 10;
			System.out.println(e);
		};
		
		CalculatorTwo calTwo = (x,y) -> {
			System.out.println(x * y);
		}; 
		
		//SE NÃO UTILIZAR CHAVES NÃO É NECESSÁRIO COLOCAR O RETURN 
		CalculatorComReturn calcR = p -> p * p; 
		
		cal.calculate(20);
		calTwo.calculate(10, 12);
		System.out.println(calcR.calculate(9));
		
		//LAMBDA COM COLLECTIONS
		List<Integer> list = Arrays.asList(10,1,27,3,4,5,15); 
		//list.forEach(e->System.out.println(e));
		
		list.sort((x,y) -> x.compareTo(y));
		//list.forEach(e->System.out.println(e));
		
		list = new ArrayList<Integer>(); 
		list.add(2); 
		list.add(3); 
		list.add(4); 
		list.add(5); 
		list.add(7); 
		list.add(6); 
		list.removeIf((e) -> e % 2 != 0); 
		list.forEach(e->System.out.println(e));
		
		
	}

}
