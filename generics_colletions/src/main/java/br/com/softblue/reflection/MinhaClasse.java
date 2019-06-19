package br.com.softblue.reflection;

public class MinhaClasse {
	
	@Executar(args = "A")
	public void m1(String param) {
		System.out.println("M1 : "+ param);
	}
	
	@Executar(args = "B")
	public void m2(String param) {
		System.out.println("M2 : "+ param);
	}
	
	public void m3() {
		System.out.println("M3");
	}

}
