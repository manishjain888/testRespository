package com.mycompany.manish;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class FibonacciRecurrsiveTest {

	@Test
	public void test() {

		int x = 7;
		System.out.println(fibRecursive(x));
		System.out.println(fibNormal(x));
	
	}
	
	private int fibRecursive(int x){
		
		if(x<0 || x > Integer.MAX_VALUE)
			throw new IllegalArgumentException("invalid value");
		
		if(x== 0 || x==1)
			return x;
		
		else{
			 return fibRecursive(x-1) + fibRecursive(x-2);
		}
		
	}
	
	private int fibNormal(int x){
		if (x < 0)
			throw new IllegalArgumentException("cannot be nagative");
		if (x == 0 || x == 1)
			return x;
		else {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(0);
			list.add(1);

			for (int i = 2; i <= x; i++) {
				list.add(i, list.get(i - 1) + list.get(i - 2));
			}
			return list.getLast();
		}

	}

}
