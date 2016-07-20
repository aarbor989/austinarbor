package com.austinarbor.solutions.vazirani;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxContiguousSum {
	
	public static void main(String[] args) {
		//int[] input = {5,15,-30,10,-5,40,10};
		int[] input = {-8,-9,-1,-2,-3,-4,-5};
		System.out.println(maxSum(input));
	}
	
	public static int maxSum(int[] input) {
		int[] S = new int[input.length];
		S[0] = input[0];
		int max = Integer.MIN_VALUE;
		List<Integer> maxContig = new ArrayList<>();
		List<Integer> curSeq = new ArrayList<>();
		curSeq.add(input[0]);
		for(int i=1; i < input.length; i++) {
			S[i] = Math.max(input[i], input[i] + S[i-1]);
			curSeq.add(input[i]);
			if(S[i] == input[i]) {
				curSeq = new ArrayList<>();
				curSeq.add(input[i]);
			}
			if(S[i] > max) {
				max = S[i];
				maxContig = new ArrayList<>(curSeq);
			}
		}
		
		System.out.println(Arrays.toString(maxContig.toArray()));
		return max;
	}

}
