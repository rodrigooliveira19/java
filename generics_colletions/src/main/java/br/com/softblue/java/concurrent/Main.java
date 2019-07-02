package br.com.softblue.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		execute2();
		

	}
	
	public static void execute1() {
		//ExecutorService e = Executors.newSingleThreadExecutor(); 
		ExecutorService e = Executors.newFixedThreadPool(5); 
		
	    for (int i = 0; i <= 5; i++) {
			Task t = new Task(i); 
			e.execute(t);	
		}
	}
	
	//Uso de ReetrantLock
	public static void execute2() {
		ExecutorService e = Executors.newFixedThreadPool(2); 
		
		ContaBancaria conta = new ContaBancaria(); 
		
		Cliente c1 = new Cliente(conta); 
		Cliente c2 = new Cliente(conta); 
		
		e.execute(c1);
		e.execute(c2);
		
		e.shutdown();
		
		try {
			while(!e.isTerminated()) {
				Thread.sleep(200);
			}
		} catch (Exception e2) {
			
		}
		
		
		System.out.println("Saldo: R$ " + String.format("%.2f",conta.getSaldo()));
		
	}
		
	

}
