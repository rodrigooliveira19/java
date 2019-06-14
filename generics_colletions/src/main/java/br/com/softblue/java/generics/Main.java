package br.com.softblue.java.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		/*//PRIMEIRO EXEMPLO DO USO DE GENERICS
		List<String> strings = new ArrayList<String>(); 
		
		strings.add("rodrigo");
		strings.add("estudando");
		strings.add("java 12");
		
		for (String string : strings) {
			System.out.println(string);
		}; 
		*/
		
		Buffer<String> buffer = new Buffer<String>(); 
		
		buffer.adicionar("a");
		buffer.adicionar("b");
		buffer.adicionar("c");
		
		String a = buffer.remover(); 
		String b = buffer.remover(); 
		String c = buffer.remover(); 
		
		System.out.println(a+", "+b+", "+c);
		
		Buffer<Integer> buffer2 = new Buffer<Integer>(); 
		
		buffer2.adicionar(10);
		buffer2.adicionar(20);
		buffer2.adicionar(30);
		
		int a1 = buffer2.remover(); 
		int b2 = buffer2.remover(); 
		int c3 = buffer2.remover(); 
		
		System.out.println(a1+", "+b2+", "+c3);
		
		
		

	}

}
