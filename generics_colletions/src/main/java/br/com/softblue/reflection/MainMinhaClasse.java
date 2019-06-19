package br.com.softblue.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainMinhaClasse {

	public static void main(String[] args) throws Exception {
		MinhaClasse classe = new MinhaClasse(); 
		
		executar(classe);

	}
	
	//OBJETIVO DO MÉTODO É EXECUTAR APENAS O MÉTODO COM A ANOTAÇÃO
	@SuppressWarnings("unchecked")
	private static void executar(MinhaClasse mc) throws Exception{
		Class<MinhaClasse> c  = (Class<MinhaClasse>) mc.getClass(); 
		
		Method[] methods = c.getDeclaredMethods(); 
		
		for (Method method : methods) {
			Executar annot = method.getDeclaredAnnotation(Executar.class); 
			
			if(annot != null) {
				String args = annot.args(); //RETORNA O VALOR DO ATRIBUTO DA ANOTATION
				method.invoke(mc,args); 
			}
			
		}
	}

}
