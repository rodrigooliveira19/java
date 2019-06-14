package br.com.softblue.java.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<String> strings = new ArrayList<String>(); 
		
		strings.add("rodrigo");
		strings.add("estudando");
		strings.add("java 12");
		
		for (String string : strings) {
			System.out.println(string);
		}

	}

}
