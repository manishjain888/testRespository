package com.mycompany.manish;

/*
 * A non-empty zero-indexed array A consisting of N integers is given.
A permutation is a sequence containing each element from 1 to N once, and only once.
For example, array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation.
The goal is to check whether array A is a permutation.
Write a function:
int solution(int A[], int N);
that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.
For example, given array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.
Given array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.
Assume that:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
Copyright 2009–2014 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PermCheckTest {

	@Test
	public void test() {
		int[] A = {4,1,3};
		System.out.println(permCheck(A));
	}

	private boolean permCheck(int[] A) {
		boolean result = true; 
		if (A.length == 0 || A.length > 100000)
			throw new IllegalArgumentException("Invalid Array");
		Arrays.sort(A);
		for(int i=1;i<=A.length;i++){
			if (A[i-1] < 0 || A[i-1] > 1000000000)
				throw new IllegalArgumentException("Illegal Element in Array");
			if(Arrays.binarySearch(A, i) < 0 )
				return false;
		}
		return true;
	}

}
