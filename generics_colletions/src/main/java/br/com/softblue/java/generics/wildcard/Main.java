package br.com.softblue.java.generics.wildcard;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Bebida> bebidas = new ArrayList<Bebida>(); 
		List<Cha> chas = new ArrayList<Cha>(); 
		List<Cafe> cafes = new ArrayList<Cafe>(); 
		
		bebidas.add(new Cafe()); 
		bebidas.add(new Cha()); 
		
		chas.add(new Cha());
		chas.add(new Cha());
		
		cafes.add(new Cafe()); 
		//cafes.add(new ); 
		
		prepararBebidas(bebidas);
		prepararBebidas2(chas);
		prepararBebidas3(cafes);
		
	}
	
	// M�TODO QUE ACEITA APENAS LISTA DE BEBIDA
	private static void prepararBebidas(List<Bebida> bebidas) {
		for (Bebida bebida : bebidas) {
			bebida.preparar();
		}
	}

	// M�TODO QUE ACEITA LISTA DE BEBIDA OU QUALQUER OUTRA LISTA DE
	//CLASSE QUE EXTENDE DE BEBIDA. EX : LISTA DE CHA
	private static void prepararBebidas2(List<? extends Bebida> bebidas) {
		for (Bebida bebida : bebidas) {
			bebida.preparar();
		}
	}
	
	//ACEITA LISTA DE CAF� OU QUALQUER OUTRA LISTA QUE ESTEJA ACIMA DE CAF�. 
	//NO EXEMPLO EM QUEST�O � BEBIDAS E OBJECT. 
	private static void prepararBebidas3(List<? super Cafe> bebidas) {
		for (Object obj : bebidas) {
			((Bebida) obj).preparar();
		}
	}

}
