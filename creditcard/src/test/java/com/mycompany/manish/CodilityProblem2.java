package com.mycompany.manish;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CodilityProblem2 {

	/*
	 * Write a function:
	 * 
	 * int solution(int A[], int N);
	 * 
	 * int solution(NSMutableArray *A);
	 * 
	 * int solution(const vector<int> &A);
	 * 
	 * class Solution { int solution(int[] A); }
	 * 
	 * class Solution { public int solution(int[] A); }
	 * 
	 * object Solution { def solution(A: Array[Int]): Int }
	 * 
	 * function solution(A);
	 * 
	 * function solution(A)
	 * 
	 * function solution($A);
	 * 
	 * function solution(A: array of longint; N: longint): longint;
	 * 
	 * def solution(A)
	 * 
	 * sub solution { my (@A)=@_; ... }
	 * 
	 * def solution(a)
	 * 
	 * Private Function solution ( A As Integer() ) as Integer
	 * 
	 * that, given a zero-indexed array A consisting of N integers, returns the
	 * value (or one of the values) that occurs most often in this array.
	 * 
	 * For example, given array A such that:
	 * 
	 * 
	 * A[0] = 20 A[1] = 10 A[2] = 30 A[3] = 30 A[4] = 40 A[5] = 10 the function
	 * may return 10 or 30.
	 * 
	 * Assume that:
	 * 
	 * •N is an integer within the range [1..100,000,000]; •each element of
	 * array A is an integer within the range [0..10,000]. Complexity:
	 * 
	 * •expected worst-case time complexity is O(N); •expected worst-case space
	 * complexity is O(N), beyond input storage (not counting the storage
	 * required for input arguments). Elements of input arrays can be modified.
	 */

	@Test
	public void test() {
		int[] A = { 20, 10, 30, 30, 40, 10 };
		System.out.println(output(A));
	}

	private int output(int[] ary) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int a : ary) {
			Integer freq = m.get(a);
			m.put(a, (freq == null) ? 1 : freq + 1);
		}

		int max = -1;
		int mostFrequent = -1;

		for (Map.Entry<Integer, Integer> e : m.entrySet()) {
			if (e.getValue() > max) {
				mostFrequent = e.getKey();
				max = e.getValue();
			}
		}

		return mostFrequent;

	}

}
