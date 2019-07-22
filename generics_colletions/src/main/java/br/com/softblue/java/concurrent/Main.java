package br.com.softblue.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		execute4();
		

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
	
	
	public static void execute3() {
		
		Info info = new Info(); 
		int numLeitores = 5; 
		int numEscritores = 5; 
		
		ExecutorService e = Executors.newFixedThreadPool(numLeitores + numEscritores); 
		
		for (int i = 0; i < numLeitores; i++) {
			Leitor r = new Leitor(info, "Leitor "+i); 
			e.execute(r);
		}
		
		for (int i = 0; i < numEscritores; i++) {
			Escritor w = new Escritor(info); 
			e.execute(w);
		}
	}
	
	
	public static void execute4() {
		
		int numGeradores = 3; 
		
		ExecutorService service = Executors.newFixedThreadPool(numGeradores); 
		
		for (int i = 0; i < numGeradores; i++) {
			Gerador g = new Gerador(); 
			service.execute(g);
		}
		
		service.shutdown();
		
	}
		
	

}
