package com.mycompany.manish;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;


public class FrogLeapRiver2 {

	@Test
	public final void test() {
		getTime();
	}

	/* A[0] = 1
 A[1] = 3
 A[2] = 1
 A[3] = 4
 A[4] = 2
 A[5] = 3
 A[6] = 5
 A[7] = 4
 */
	
	private void getTime(){
			
		int[] array = {1,3,1,4,2,3,5,4};
		HashMap<Integer, Integer> uniqueMap = new HashMap<Integer,Integer>();//HashMap<position, Time>
		for(int i=0;i<array.length-1;i++){
			if(!uniqueMap.containsKey(array[i])){
				uniqueMap.put(array[i], i);
			}
			
		}
		
		int max = -1;
		for(int time : uniqueMap.values()){
			if(time>max){
				max = time;
			}
		}
		
		System.out.println("Max Time: "+ max);
		
		
	}
}
