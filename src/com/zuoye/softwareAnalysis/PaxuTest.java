package com.zuoye.softwareAnalysis;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaxuTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBubbleSort10() {
		int[] arr = RandomArray.getArray(10);
		int[] arrResult = Paxu.bubbleSort(arr, 10);
		System.out.print("\nSort10");
		for(int i=0; i<arrResult.length;i++){
			System.out.print("  "+arrResult[i]);
		}
		
	}
	@Test
	public void testBubbleSort100() {
		int[] arr = RandomArray.getArray(100);
		int[] arrResult = Paxu.bubbleSort(arr, 100);
		System.out.print("\nSort100");
		for(int i=0; i<arrResult.length;i++){
			System.out.print("  "+arrResult[i]);
		}
		
	}
	@Test
	public void testBubbleSort10000() {
		int[] arr = RandomArray.getArray(10000);
		int[] arrResult = Paxu.bubbleSort(arr, 10000);
		System.out.print("\nSort10000");
		for(int i=0; i<arrResult.length;i++){
			System.out.print("  "+arrResult[i]);
		}
		
	}
	
	@Test
	public void testBubbleSort0() {
		int[] arr = RandomArray.getArray(0);
		int[] arrResult = Paxu.bubbleSort(arr, 0);
		System.out.print("\nSort0");
		for(int i=0; i<arrResult.length;i++){
			System.out.print("  "+arrResult[i]);
		}
	}
	@Test
	public void testBubbleSortMillion() {
		int[] arr = RandomArray.getArray(1000000);
		int[] arrResult = Paxu.bubbleSort(arr, 1000000);
		System.out.print("\nSort1000000");
		for(int i=0; i<arrResult.length;i++){
			System.out.print("  "+arrResult[i]);
		}
	}

}
