package br.com.softblue.java.concurrent;

import java.util.concurrent.RecursiveTask;

public class SumArray extends RecursiveTask<Integer>{

	private int[] array; 
	private int min; 
	private int max; 
	
	
	public SumArray(int[] array, int min, int max) {
		super();
		this.array = array;
		this.min = min;
		this.max = max;
	}


	@Override
	protected Integer compute() {
		int length = max - min +1; 
		
		if(length < 4) {
			int partialSum = 0; 
			
			for (int i = min; i <= max; i++) {
				partialSum +=array[i]; 
			}
			
			return partialSum; 
		}
		
		//DIVISÃO DO ARRAY. E USO DE RECURSÃO. 
		int half = length / 2; 
		
		SumArray leftTask = new SumArray(array, min, min + half); 
		SumArray rightTask = new SumArray(array, min + half +1, max); 
		
		leftTask.fork() ; 
		rightTask.fork(); 
		
		int leftTaskSum = leftTask.join(); 
		int rightTaskSum = rightTask.compute(); 
		
		return leftTaskSum + rightTaskSum;
	}

}
