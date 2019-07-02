package br.com.softblue.java.concurrent;

public class Task implements Runnable{
	
	private int id; 
	
	public Task(int id) {
		this.id = id; 
	}

	@Override
	public void run() {
		System.out.println("Tarefa "+this.id+" iniciando");
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}
		
		System.out.println("Tarefa "+this.id+" terminando");
		
	}

}
