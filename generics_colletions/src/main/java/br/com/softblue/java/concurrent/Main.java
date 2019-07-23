package br.com.softblue.java.concurrent;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Main {

	public static void main(String[] args) {
		
		execute5();
		

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
	
	
	public static void execute5() {
		
		int[] array = new int[4]; 
		Arrays.fill(array, 1);
		
		SumArray sumArray = new SumArray(array, 0, array.length - 1); 
		ForkJoinPool forkJoin = new ForkJoinPool(); 
		
		int sum = forkJoin.invoke(sumArray); 
		
		System.out.println("Soma :"+sum);
		
	}
		
	

}
