package com.mycompany.manish;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.ListIterator;

import junit.framework.Assert;

import org.junit.Test;

public class DataStructureTest {

	/**
	 * Finding the middle element in the list in single pass
	 * 1. Create the LinkedList with 10 elements
	 * 2. Create two pointers, one pointer increments one and other increments two
	 * 3. The way first pointer reaches at the end, second will be in the middle
	 */
	@Test
	public final void linkedListSinglePasstest() {

		java.util.LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=1;i<=10;i++){
			list.add(i);
		}
		Assert.assertEquals(new Integer(5), getMiddleElement(list));
		
	}
	
	/**
	 * Quick Sort
	 * {@link http://tekmarathon.wordpress.com/2013/09/17/understanding-quicksort-algorithm/}
	 * <br/>
	 * 1. find the lowest and highest index element
	 * 2. Take a pivot as lowest element
	 * 3. since we have to divide the array into 2 parts
	 * 4. keep incrementing the low index until low in greater than pivot
	 * 5. keep decrementing the high index until high in less than pivot
	 */
	@Test
	public void quickSortTest(){
		Integer[] a  = new Integer[]{3, 7, 9, 1, 6, 5, 4};
		quickSort(a, 0, a.length-1);
	
	}

	private void quickSort(Integer[] a, int i, int j){
		int idx = partition(a, i, j);
		if(i<idx-1){
			quickSort(a, i, idx-1);
		if(j<idx)	
			quickSort(a, idx, j);
		}
		/*for(Integer w: a){
			System.out.println(w);
		}*/
	}
	private int partition(Integer[] a, int low,int high){
		int pivot = a[0];
		while(low <= high){
			while(a[low]<pivot)
				low++;
			while(a[high]>pivot)
				high--;
			
			if(low<=high){
				//swap array
				low++;
				high--;
			}
		}
		return low;
	}
	
	private void bubbleSort(int[] num){
		for(int i=0;i<=num.length;i++)
			for(int j=1;j<=num.length-1;j++){
				if(num[j-1]>num[i])
				{
					//swap array
				}
			}
	}
	
	private int binarySearch(int[] num, int searchNum){
		int start = num[0];
		int end = num[num.length-1];
		int mid = 0;
		while(start<=end){
			mid = (start+end)/2;
			if(num[mid]==searchNum){
				return mid;
			}
			else if(num[mid]<searchNum)
			{
				start = mid+1;
			}
			else{
				end = mid-1;
			}
		}
		return -1;
	}

	
	private Integer getMiddleElement(java.util.LinkedList<Integer> list) {
		ListIterator<Integer> firstIterator = (ListIterator<Integer>) list.iterator();
		ListIterator<Integer> secondIterator = (ListIterator<Integer>) list.iterator();

		Integer value = null;
		while(firstIterator.hasNext()){
			if(secondIterator.hasNext())
			{
				secondIterator.next();
				if(secondIterator.hasNext())
					secondIterator.next();
				else
					break;
			}
			else
				break;
			value = firstIterator.next();
		}
		return value;
	}

}

/*class LinkedList{
	private Node head;
	private Node tail;
}

class Node{
	private Node next;
	private String data;
}*/