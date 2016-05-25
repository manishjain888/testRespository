package com.mycompany.manish;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CodilityProblem3 {

	/*
	 * A zero-indexed array A consisting of N different integers is given. The
	 * array contains all integers in the range [0..N−1]. Sets S[K] for 0 ≤ K <
	 * N are defined as follows:
	 * 
	 * 
	 * S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.
	 * 
	 * 
	 * Sets S[K] are finite for each K.
	 * 
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
	 * that, given an array A consisting of N integers, returns the size of the
	 * largest set S[K] for this array. The function should return 0 if the
	 * array is empty.
	 * 
	 * For example, given array A such that:
	 * 
	 * 
	 * A[0] = 5 A[1] = 4 A[2] = 0 A[3] = 3 A[4] = 1 A[5] = 6 A[6] = 2 the
	 * function should return 4, because set S[2] equals { 0, 5, 6, 2 } and has
	 * four elements. No other set S[K] has more than four elements.
	 * 
	 * Assume that:
	 * 
	 * •N is an integer within the range [0..1,000,000]; •the elements of A are
	 * all distinct; •array A contains all elements from the integer interval
	 * [0..N−1]. Complexity:
	 * 
	 * •expected worst-case time complexity is O(N); •expected worst-case space
	 * complexity is O(N), beyond input storage (not counting the storage
	 * required for input arguments). Elements of input arrays can be modified.
	 */

	@Test
	public void test() {
		int[] A = { 5, 4, 0, 3, 1, 6, 2 };
		System.out.println(output(A));
	}

	private int output(int[] A) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		int counter = 0;
		for (int K = 0; K < A.length; K++) {
			counter = 1;
			for (int index = A[K]; index < A.length - 1; index = A[index]) {
				counter++;
				System.out.println("K "+K +", counter "+ counter +
						" , index "+index + ", A[index] "+A[index]);
				if(index==A[A[index]] ){
					m.put(K, counter);
					break;
				}
				m.put(K, counter);
			}

		}

		System.out.println(m.toString());

		int mostFrequent = -1;
		int max = -1;
		for (Map.Entry<Integer, Integer> e : m.entrySet()) {
			if (e.getValue() > max) {
				mostFrequent = e.getKey();
				max = e.getValue();
			}
		}

		return max;

	}

}
