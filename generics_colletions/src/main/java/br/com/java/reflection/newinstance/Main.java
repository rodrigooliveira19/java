package br.com.java.reflection.newinstance;

import java.io.File;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		
		String className = null; 
		try {
			Scanner scanner = new Scanner(new File("new_instance.txt")); 
			className = scanner.nextLine(); 
			
		} catch (Exception e) {
			
		}; 
		
		Class<Bebida> bebidaClass = (Class<Bebida>) Class.forName(className); 
		Bebida bebida = bebidaClass.getDeclaredConstructor().newInstance(); 
		bebida.preparar();
		

	}

}
