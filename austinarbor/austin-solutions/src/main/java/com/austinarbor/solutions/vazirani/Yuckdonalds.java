package com.austinarbor.solutions.vazirani;

import java.util.Arrays;

public class Yuckdonalds {
	
	public static void main(String[] args) {
		int[] m = {0,5,10,15,19,25,28,29};
        int[] p = {0,10,4,61,21,13,19,15};
        int k = 5;
        System.out.println(maxProfit(m,p,k));
	}
	
	public static int maxProfit(int[] distances, int[] profits, int k) {
		int[] P = new int[distances.length+1];
		for(int i=2; i <= distances.length; i++) {
			for(int j=1; j < i; j++) {
				int temp = P[j] + (alpha(distances[i-1],distances[j-1],k) * profits[i-1]);
				if(temp > P[i]) {
					 P[i] = temp;
				} 
			}
			if( P[i] < profits[i-1]) {
				P[i] = profits[i-1];
			}
			
		}
		System.out.println(Arrays.toString(P));
		return P[distances.length];
	}
	
	public static int alpha(int m1, int m2, int k) {
		if((m1-m2) >= k) {
			return 1;
		}
		return 0;
	}

}
