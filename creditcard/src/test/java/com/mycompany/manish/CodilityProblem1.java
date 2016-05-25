package com.mycompany.manish;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CodilityProblem1 {

	/*
	 * A non-empty array A consisting of N integers is given. Let X[0], X[1],
	 * ..., X[N−1] be the elements of A arranged in non-decreasing order; thus
	 * the median of A is the value X[N/2].
	 * 
	 * For example, the median of array A such that
	 * 
	 * A[0] = 1, A[1] = 2, A[2] = 5, A[3] = 10, A[4] = 20, A[5] = 1
	 * 
	 * is 5, because the elements of this array arranged in non-decreasing order
	 * are
	 * 
	 * X[0] = 1, X[1] = 1, X[2] = 2, X[3] = 5, X[4] = 10, X[5] = 20, and X[6/2]
	 * = X[3] = 5.
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
	 * that, given a zero-indexed array A consisting of N integers, returns the
	 * median of the array A.
	 * 
	 * For example, given array A such that:
	 * 
	 * 
	 * A[0] = 1 A[1] = 2 A[2] = 5 A[3] = 10 A[4] = 20 A[5] = 1 the function
	 * should return 5, as explained above.
	 * 
	 * Assume that:
	 * 
	 * •N is an integer within the range [1..100,000]; •each element of array A
	 * is an integer within the range [0..1,000,000,000]. Complexity:
	 * 
	 * •expected worst-case time complexity is O(N*log(N)); •expected worst-case
	 * space complexity is O(N), beyond input storage (not counting the storage
	 * required for input arguments). Elements of input arrays can be modified.
	 * 
	 * Copyright 2009–2013 by Codility Limited. All Rights Reserved.
	 * Unauthorized copying, publication or disclosure prohibited.
	 */
	@Test
	public void test() {
		int[] A = { 1, 2, 5, 10, 20, 1, 8 };
		System.out.println(outputMedian(A));
	}

	private int outputMedian(int[] A) {

		int median = 0;
		if (A.length == 0 || A.length > 100000)
			throw new IllegalArgumentException("Invalid Array");

		for (int i = 0; i < A.length; i++) {
			if (A[i] < 0 || A[i] > 1000000000)
				throw new IllegalArgumentException("Illegal Element in Array");
		}
		if (A.length > 0) {
			Arrays.sort(A);
			int middleIndex = A.length / 2;
			median = A[middleIndex];
		}
		return median;
	}
}
