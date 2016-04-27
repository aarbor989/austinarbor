package com.austinarbor.alg.sort;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class MergeSortTest {
	
	@Test
	public void mergeSortTest_1() {
		List<Integer> data = new ArrayList<Integer>(10000000);
		Random rand = new Random(System.currentTimeMillis());
		for(int i=0; i < 10000000; i++) {
			data.add(rand.nextInt(30000000));
			//data.set(i, rand.nextInt());
		}
		
		Sort<Integer> mergeSort = new MergeSort<Integer>(data);
		long start = System.currentTimeMillis();
		data = mergeSort.sort();
		long duration = System.currentTimeMillis() - start;
		System.out.println("Duration: " + duration/1000);
		/*for(int i=0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}*/
		
		for(int i=1; i < data.size(); i++) {
			assertTrue((data.get(i) >= data.get(i-1)));
		}
		
		
	}

}
