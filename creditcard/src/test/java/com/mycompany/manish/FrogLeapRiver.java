package com.mycompany.manish;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/*
 A small frog wants to get to the other side of a river. The frog is currently located at position 0, and wants to get to position X.
  Leaves fall from a tree onto the surface of the river. You are given a non-empty zero-indexed array A consisting of N integers 
  representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in minutes.

 The goal is to find the earliest time when the frog can jump to the other side of the river. 
 The frog can cross only when leaves appear at every position across the river from 1 to X.

 For example, you are given integer X = 5 and array A such that:


 A[0] = 1
 A[1] = 3
 A[2] = 1
 A[3] = 4
 A[4] = 2
 A[5] = 3
 A[6] = 5
 A[7] = 4
 In minute 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

 Write a function:

 int solution(int X, int A[], int N); 

 int solution(int X, NSMutableArray *A); 

 int solution(int X, vector<int> &A); 

 class Solution { int solution(int X, int[] A); } 

 class Solution { public int solution(int X, int[] A); } 

 object Solution { def solution(X: Int, A: Array[Int]): Int } 

 function solution(X, A); 

 function solution(X, A) 

 function solution($X, $A); 

 function solution(X: longint; A: array of longint; N: longint): longint; 

 def solution(X, A) 

 sub solution { my ($X, @A)=@_; ... } 

 def solution(x, a) 

 Private Function solution ( X As Integer, A As Integer() ) as Integer 

 that, given a non-empty zero-indexed array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

 If the frog is never able to jump to the other side of the river, the function should return −1.

 For example, given X = 5 and array A such that:


 A[0] = 1
 A[1] = 3
 A[2] = 1
 A[3] = 4
 A[4] = 2
 A[5] = 3
 A[6] = 5
 A[7] = 4
 the function should return 6, as explained above. Assume that:

 •N and X are integers within the range [1..100,000];
 •each element of array A is an integer within the range [1..X].
 Complexity:

 •expected worst-case time complexity is O(N);
 •expected worst-case space complexity is O(X), beyond input storage (not counting the storage required for input arguments).
 Elements of input arrays can be modified.

 */

@RunWith(Parameterized.class)
public class FrogLeapRiver {

	private int[] A;
	private int X;
	private int output;
	
	@Parameters
	public static Collection<Object[]> prepareData(){

		Collection<Object[]> args = new ArrayList<Object[]>();
		args.add(new Object[]{new int[]{1,3,1,4,2,3,5,4},5,6});
		args.add(new Object[]{new int[]{1, 2, 3, 5, 3, 1},5,-1});
		args.add(new Object[]{new int[]{1, 3, 1, 3, 2, 1, 3},3,4});
		args.add(new Object[]{new int[]{3},5,-1});
		return args;
	}
	
	@Test
	public void test() {
		/*int actualOutput = output3(X,A);
		System.out.println(actualOutput);
		assertEquals(output, actualOutput);*/
		getTime();
	}
	
	@Ignore
	public void test2(){
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(2);
		set.add(1);
		set.add(5);
		set.add(4);
		System.out.println("last "+set.last());
	}
	
	public FrogLeapRiver(int[] A,int X, int output)      
	 {
		this.A = A;            
		this.X = X;            
		this.output = output;      
	 } 
	
	
	private int output(int X, int[] A){
		System.out.println("X "+ X + " A "+ Arrays.toString(A));
		int index = -1;
		boolean matched =false;
		if (A.length == 0 || A.length > 100000)
			throw new IllegalArgumentException("Invalid Array");
		if (X < 1 || X > 100000)
			throw new IllegalArgumentException("Invalid X");
		for(int i = 1;i<=X ; i++){
			matched=false;
			for(int j=0;j<A.length;j++){
				if (A[j] < 1 || A[j] > 100000)
					throw new IllegalArgumentException("Invalid Element");
				if(i==A[j]){
					matched =true;
					if(j>index)
						index = j;
					break;
				}
				
			}
			if(!matched)
				return -1;
			
		}
		return index;
	}
	
	private int output2(int X, int[] A){
		int maxIndex = -1;
		
		List<Integer> list = new ArrayList<Integer>();
	    for (int index : A)
	    {
	        list.add(index);
	    }
		for(int i = 1;i<=X;i++){
			if(list.contains(i)){
				if(list.indexOf(i)>maxIndex )
					maxIndex = list.indexOf(i);
				continue;
			}
			else 
				return -1;
		}
		
		return maxIndex;
	}
	
	private int output3(int X, int[] A){
		TreeSet<Integer> indexSet = new TreeSet<Integer>();
    	for(int j=1;j<=X;j++){
    		 for (int i=0;i<A.length;i++)
    		    {
    			 if(A[i]==j)
    				 indexSet.add(j);
    			 	break;
    		    }
    	}
    	System.out.println("index size "+indexSet.size() + " X = "+X);
    	if(indexSet.size()!=X)
    		return -1;
    	else
    		return indexSet.last();
		
		
	}
	private void getTime(){
		int totalSum =0;
		int finalPosition = 6;
		while(finalPosition!=0){
			totalSum = totalSum+finalPosition;
			finalPosition--;
		}
		
		System.out.println("totalSum = "+totalSum);
		
		
	}

}
