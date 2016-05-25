package com.mycompany.manish;

import static org.junit.Assert.*;

import java.util.Arrays;

import javax.naming.InitialContext;

import org.junit.Test;

public class TapeEquilibriumTest {

	/**
	 * A non-empty zero-indexed array A consisting of N integers is given. Array
	 * A represents numbers on a tape.
	 * 
	 * Any integer P, such that 0 < P < N, splits this tape into two non−empty
	 * parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
	 * 
	 * The difference between the two parts is the value of: |(A[0] + A[1] + ...
	 * + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
	 * 
	 * In other words, it is the absolute difference between the sum of the
	 * first part and the sum of the second part.
	 * 
	 * For example, consider array A such that:
	 * 
	 * 
	 * A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 4 A[4] = 3 We can split this tape in
	 * four places:
	 * 
	 * •P = 1, difference = |3 − 10| = 7
	 * 
	 * •P = 2, difference = |4 − 9| = 5
	 * 
	 * •P = 3, difference = |6 − 7| = 1
	 * 
	 * •P = 4, difference = |10 − 3| = 7
	 * 
	 * Write a function:
	 * 
	 * int solution(int A[], int N);
	 * 
	 * int solution(NSMutableArray *A);
	 * 
	 * int solution(vector<int> &A);
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
	 * that, given a non-empty zero-indexed array A of N integers, returns the
	 * minimal difference that can be achieved.
	 * 
	 * For example, given:
	 * 
	 * 
	 * A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 4 A[4] = 3 the function should return
	 * 1, as explained above.
	 * 
	 * Assume that:
	 * 
	 * •N is an integer within the range [2..100,000]; •each element of array A
	 * is an integer within the range [−1,000..1,000]. Complexity:
	 * 
	 * •expected worst-case time complexity is O(N); •expected worst-case space
	 * complexity is O(N), beyond input storage (not counting the storage
	 * required for input arguments). Elements of input arrays can be modified.
	 * 
	 * Copyright 2009–2013 by Codility Limited. All Rights Reserved.
	 * Unauthorized copying, publication or disclosure prohibited. add your test
	 * case(s)
	 */

	@Test
	public void test() {
		int A[] = {3,1,2,4,3};
		System.out.println(""+outputTapeEquilibrium(A));
	}

	private int outputTapeEquilibrium(int A[]) {

		int intialPartSum = 0;
		int difference = 0;
		int finalDifference = 0 ;
		
		if(A.length > 1 && A.length <= 100000){
		
			for(int i = 0; i< A.length-1;i++){
				if(A[i]<-1000 || A[i]>1000)
					throw new IllegalArgumentException("ArrayElement is not right");
				intialPartSum = intialPartSum+ A[i];
				int[] subarray = Arrays.copyOfRange(A, i+1, A.length);
				int subArraySum = 0;
				for(int j = 0;j<subarray.length;j++){
					if(subarray[j]<-1000 || subarray[j]>1000)
						throw new IllegalArgumentException("ArrayElement is not right");
					subArraySum = subArraySum+ subarray[j];
				}
				difference = Math.abs(intialPartSum - subArraySum);
				if(finalDifference == 0)
					finalDifference  = difference;
				else
				{
					if(finalDifference > difference)
						finalDifference = difference;
				}
			}
		}
		else {
			throw new IllegalArgumentException("Array out of range");
		}
		
		return finalDifference;
	}

}
