package br.com.softblue.java.concurrent;

public class Leitor implements Runnable{
	
	private Info info; 
	private String nome;
	
	
	public Leitor(Info info, String nome) {
		super();
		this.info = info;
		this.nome = nome;
	} 
	
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				String texto = this.info.getInfo(); 
				System.out.println(this.nome +" => leu "+texto);
				Thread.sleep(200);
			}
		} catch (Exception e) {

		}

	}
	
	

}
