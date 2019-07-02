package br.com.softblue.java.concurrent;

public class Cliente implements Runnable{

	private ContaBancaria conta; 
	
	
	public Cliente(ContaBancaria conta) {
		this.conta = conta;
	}


	@Override
	public void run() {
		try {
			for (int i = 0; i <= 5; i++) {
				this.conta.depositar(100);
				Thread.sleep(200);
				this.conta.sacar(100);
			}
		} catch (Exception e) {
			
		}
		
	}

}
