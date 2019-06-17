package br.com.softblue.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		//ACESSANDO ATRIBUTOS
		Class<Televisao> tvClass =  Televisao.class; 
		Field[] filds = tvClass.getDeclaredFields(); 
		
		for (Field field : filds) {
			System.out.println("atributo: "+field.getName() +" | "+field.getType());
		}
		
		//ACESSANDO METODOS
		Method[] methods = tvClass.getDeclaredMethods(); 
		
		for (Method method : methods) {
			System.out.println("metodo: "+method.getName() +" | "
					+method.getReturnType() +" | "+method.getParameterCount() +" | "+Arrays.toString(method.getParameters()));
		}
		
		System.out.println();
		
		//INSTACIANDO OBJETOS E ACESSANDO METODOS COM REFLECTION
		Class tvObject = Class.forName("br.com.softblue.reflection.Televisao"); 
		Televisao tv = (Televisao) tvObject.getDeclaredConstructor().newInstance(); 
		
		Method mudarCanal = tvObject.getDeclaredMethod("mudarCanal", int.class); 
		mudarCanal.invoke(tv, 100); 
		
	
	}

}
