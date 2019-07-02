package br.com.softblue.java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ContaBancaria {
	
	private ReentrantLock lock = new ReentrantLock(); 
	private double saldo; 
	
	
	public void sacar(double saldo) {
		this.lock.lock();
		try {
			this.saldo -= saldo; 
		}finally {
			this.lock.unlock();
			
		}
	}
	
	public void depositar(double saldo) {
		this.lock.lock();
		try {
			this.saldo += saldo;
		} finally {
			this.lock.unlock();

		}
	}
	
	public double getSaldo() {
		return this.saldo; 
	}

}
