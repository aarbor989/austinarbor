package com.austinarbor.alg.sort;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class ArrayMergeSortTest {
	@Test
	public void mergeSortTest_1() {
		Integer[] data = new Integer[10000000];
		Random rand = new Random(System.currentTimeMillis());
		for(int i=0; i < 10000000; i++) {
			data[i] = rand.nextInt(30000000);
			//data.set(i, rand.nextInt());
		}
		
		ArraySort<Integer> mergeSort = new ArrayMergeSort<Integer>(data,Integer.class);
		final long start = System.currentTimeMillis();
		data = mergeSort.sort();
		final long duration = System.currentTimeMillis() - start;
		System.out.println("Duration: " + duration);
		/*for(int i=0; i < data.length; i++) {
			System.out.println(data[i]);
		}*/
		
		for(int i=1; i < data.length; i++) {
			assertTrue((data[i]) >= data[i-1]);
		}
		
		
	}
}
