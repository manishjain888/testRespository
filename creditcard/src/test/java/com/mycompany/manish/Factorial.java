package com.mycompany.manish;

import static org.junit.Assert.*;

import org.junit.Test;

public class Factorial {

	@Test
	public final void test() {
		System.out.println(factorial(5));
	}
	
	private int factorial(int num){
		int factorial=0;
		if(num==0 || num==1)
			return num;

		factorial= factorial(num-1)*num;
		return factorial;
	}

}
