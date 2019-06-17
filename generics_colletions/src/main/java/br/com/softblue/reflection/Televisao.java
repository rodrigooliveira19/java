package br.com.softblue.reflection;

public class Televisao {
	
	private boolean ligada; 
	private int canal; 
	
	public Televisao() {
		System.out.println("Televisão Ligada");
	}
	
	public void ligar() {
		this.ligada = true; 
		System.out.println("Televisão Ligada");
	}
	
	public void desligar() {
		this.ligada = false; 
		System.out.println("Televisão desligada");
	}
	
	public void mudarCanal(int canal) {
		this.canal = canal; 
		System.out.println("Canal mudado para "+this.canal);
	}
	
	public boolean isLigada() {
		return this.ligada; 
	}
	
	public int getCanal() {
		return this.canal; 
	}

}
