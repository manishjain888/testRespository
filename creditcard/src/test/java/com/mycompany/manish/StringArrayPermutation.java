package com.mycompany.manish;

import static org.junit.Assert.*;

import java.text.StringCharacterIterator;

import org.junit.Test;

public class StringArrayPermutation {

	static int count = 0;
	/**
	 * Requirement
	 * 1. Given an array char[] = {A,B,C}
	 * 2. Output should print all possible values of this array
	 * i.e [{ABC}, {BAC},{CBA}, {ACB},{BCA},{CAB}]
	 */
	@Test
	public final void test() {
		String str = "abc";
		permutation("", str);
		System.out.println(count);
	}

	private static void permutation(String prefix, String str) {
		count++;
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
}
