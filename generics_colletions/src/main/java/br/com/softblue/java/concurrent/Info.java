package br.com.softblue.java.concurrent;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class Info {
	
	private String info = "AAAAAAAAAA"; 
	private Random random = new Random();
	
	private ReentrantReadWriteLock rwl = new  ReentrantReadWriteLock(); 
	private ReadLock r = rwl.readLock(); 
	private WriteLock w = rwl.writeLock(); 
	
	
	public String getInfo() {
		try {
			r.lock();
			return this.info; 
		} finally {
			r.unlock();
		}
	}
	
	public void setInfo() {
		try {
			w.lock();
			this.info = ""; 
			
			for (int i = 0; i < 10; i++) {
				char c = (char)(this.random.nextInt(26) + 65); 
				this.info+= c; 
				try {
					Thread.sleep(200);
				} catch (Exception e) {
					
				}
			}
			
		} finally {
			w.unlock();
		}
	}

}
