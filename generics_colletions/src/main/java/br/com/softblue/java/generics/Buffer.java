package br.com.softblue.java.generics;

import java.util.ArrayList;
import java.util.List;

public class Buffer<T> {
	
	private List<T> buffer = new ArrayList<T>(); 
	 
	
	public void adicionar(T elemento) {
		this.buffer.add(elemento); 
	}
	
	public T remover() {
		T elemento = this.buffer.get(0); 
		this.buffer.remove(0); 
		
		return  elemento; 
	}

}
