package br.com.softblue.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		execute1();
		

	}
	
	public static void execute1() {
		
		//ExecutorService e = Executors.newSingleThreadExecutor(); 
		ExecutorService e = Executors.newFixedThreadPool(5); 
		
	    for (int i = 0; i <= 5; i++) {
			Task t = new Task(i); 
			e.execute(t);	
		}
	}

}
