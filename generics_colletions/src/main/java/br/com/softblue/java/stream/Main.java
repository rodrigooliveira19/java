package br.com.softblue.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	static List<String> itens = Arrays.asList("Lápis", "Mesa","Caneta","Caderno","Borracha","Quadro"); 

	public static void main(String[] args) {
		executar4();

	}
	
	public static void executar1() {
		// 1.Ordenar.
		// 2.Limitar a qtd elementos.
		// Imprimir na tela.
		
		itens.stream().sorted().limit(6).forEach((System.out::println));
	}
	
	public static void executar2() {
		// 1.Retornar uma nova Lista filtrando pelas palavras que começam com C.
		List<String> itens2 = itens.stream().filter(e -> e.charAt(0) == 'C').collect(Collectors.toList());
		itens2.stream().forEach(System.out::println);
		
	}
	
	public static void executar3() {
		// 1.Retornar uma nova Lista filtrando pelas palavras que contém com c ou C.
		List<String> itens3 = itens.stream().filter(e -> e.contains("c") || e.contains("C"))
				.collect(Collectors.toList());
		
		System.out.println(itens3);
	}
	
	public static void executar4() {
		// 1.Retorna um inteiro com o valor de caracteres de toda a lista. 
		
		int lenght = itens.stream().collect(Collectors.summingInt(e -> e.length())); 
		System.out.println(lenght);
	}
	
	public static void executar5() {
		
	}

}
