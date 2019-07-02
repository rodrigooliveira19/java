package br.com.softblue.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	
	static List<String> itens = Arrays.asList("Lápis", "Mesa","Caneta","Caderno","Borracha","Quadro"); 
	static List<Produto> produtos = new ArrayList<Produto>(); 
	

	public static void main(String[] args) {
		
		produtos.add(new Produto(1, "Banana", 5.00)); 
		produtos.add(new Produto(2, "Pera", 4.00)); 
		produtos.add(new Produto(3, "Uva", 5.50)); 
		produtos.add(new Produto(4, "Manga", 3.86)); 
		produtos.add(new Produto(5, "Granola", 6.00)); 
		produtos.add(new Produto(6, "Batata", 9.85)); 
		
		executar7();

	}
	
	public static void executar1() {
		// 1. Ordenar.
		// 2. Limitar a qtd elementos.
		// 3. Imprimir na tela.
		
		itens.stream().sorted().limit(6).forEach((System.out::println));
	}
	
	public static void executar2() {
		// 1. Retornar uma nova Lista filtrando pelas palavras que começam com C.
		List<String> itens2 = itens.stream().filter(e -> e.charAt(0) == 'C').collect(Collectors.toList());
		itens2.stream().forEach(System.out::println);
		
	}
	
	public static void executar3() {
		// 1. Retornar uma nova Lista filtrando pelas palavras que contém com c ou C.
		List<String> itens3 = itens.stream().filter(e -> e.contains("c") || e.contains("C"))
				.collect(Collectors.toList());
		
		System.out.println(itens3);
	}
	
	public static void executar4() {
		// 1. Retorna um inteiro com o valor de caracteres de toda a lista. 
		
		int lenght = itens.stream().collect(Collectors.summingInt(e -> e.length())); 
		System.out.println(lenght);
	}
	
	public static void executar5() {
		// 1. Ordenar os produtos por preço. 
		// 2. Criar um novo objeto com o valor do produto em dolar. 
		// 3. Mostar os dados do na tela. 
		
		
		
		int cotacao = 4; 
		
		produtos.stream()
		        .sorted((p1,p2) -> new Double(p1.getPreco()).compareTo(p2.getPreco()))
		        .map(p -> new Produto(p.getId() , p.getNome(), p.getPreco() / cotacao))
		        .forEach(p -> System.out.println(p.getNome() +" | "+String.format("%.2f", p.getPreco())));
		
		System.out.println(produtos.get(0).getNome() + " | "+ produtos.get(0).getPreco());
	}
	
	public static void executar6() {
		// 1. Criar um Map onde a chave é um ID e o valor o NOME do produto. 
		
		Map<Integer, String> map = produtos.stream().collect(Collectors.toMap(p -> p.getId(), p -> p.getNome())); 
		System.out.println(map);
	}
	
	public static void executar7() {
		// 1.  Criar uma representação String com os produtos. 
		
		String prods = produtos.stream()
				               .map(p -> String.format("%d:%s:%.2f", p.getId(), p.getNome(), p.getPreco()))
				               .collect(Collectors.joining(";")); 
		System.out.println(prods); 
		
	
	}

}
