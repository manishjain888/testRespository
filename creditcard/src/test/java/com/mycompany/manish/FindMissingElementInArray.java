package com.mycompany.manish;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class FindMissingElementInArray {

	/*
	 * A zero-indexed array A consisting of N different integers is given. The
	 * array contains integers in the range [1..(N + 1)], which means that
	 * exactly one element is missing.
	 * 
	 * Your goal is to find that missing element.
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
	 * that, given a zero-indexed array A, returns the value of the missing
	 * element.
	 * 
	 * For example, given array A such that:
	 * 
	 * 
	 * A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5 the function should return 4, as it
	 * is the missing element.
	 * 
	 * Assume that:
	 * 
	 * •N is an integer within the range [0..100,000]; •the elements of A are
	 * all distinct; •each element of array A is an integer within the range
	 * [1..(N + 1)]. Complexity:
	 * 
	 * •expected worst-case time complexity is O(N); •expected worst-case space
	 * complexity is O(1), beyond input storage (not counting the storage
	 * required for input arguments). Elements of input arrays can be modified.
	 */
	@Test
	public void test() {
		int[] array = {};
		//System.out.println(findMissingElementInArray(array));
		System.out.println(FindMissingPart2(array));
	}
	
	private int findMissingElementInArray(int[] A){
		Set<Integer> set = new HashSet<Integer>();
		
		if(A==null)
			throw new IllegalArgumentException("Negative elements are not allowed"); 
		
		if(A.length >0 && A.length <= 100001){
			if(A.length ==1)
				return A[0];
			Arrays.sort(A);
			int actualSum = 0;
			for(int element : A){
				if(element < 0 || element > 100001 || set.contains(element))
					throw new IllegalArgumentException("Negative elements are not allowed");
				set.add(element);
				
				actualSum = actualSum+element;
			}
			int formulizedSum = ((A.length+1) * (A[0]+ A[A.length-1]))/2;
			return formulizedSum - actualSum;
		}
		return 1;
	}
	
	private boolean checkDuplicates(int[] A){
		Set<Integer> set = new HashSet<Integer>();
		for (int element:A){
			if(set.contains(element)) return true;
			set.add(element);
		}
		return false;
	}
	
	private int FindMissingPart2(int[] A){
		int result = 0;
		if(A==null)
			throw new IllegalArgumentException("Negative elements are not allowed");
		if(A.length >0 && A.length <= 100001){
			Arrays.sort(A);
			for(int i = 1;i<=A.length+1;i++){
				result = i;
				if(Arrays.binarySearch(A, i)< 0)
					return i;
			}
			return result;
		}
		else
			return 1;
		
		
	}

}
