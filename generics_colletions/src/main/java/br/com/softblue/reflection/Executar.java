package br.com.softblue.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * Target -> Onde a anotations ser� usada. 
 * RetentionPolicy.RUNTIME -> Verifica��o durante a execu��o.
 */
@Target(ElementType.METHOD) 
@Retention(RetentionPolicy.RUNTIME)
public @interface Executar {
	
	String args(); 

}
