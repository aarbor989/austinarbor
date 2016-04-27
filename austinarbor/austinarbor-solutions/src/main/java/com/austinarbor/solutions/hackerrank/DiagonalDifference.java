package com.austinarbor.solutions.hackerrank;

import java.util.Scanner;

public class DiagonalDifference {

	public static int diagonalDifference(int[][] a) {
		int firstSum=0;
		int secSum=0;
		int i=0;
		int j=0;
		int k=a[0].length-1;
		while(true) {
			firstSum+= a[i][j];
			secSum+=a[i][k];
			i++;
			j++;
			k--;
			if(i >= a[0].length) {
				break;
			}
		}

		return Math.abs(firstSum-secSum);
	}

	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int a[][] = new int[n][n];
			for(int a_i=0; a_i < n; a_i++){
				for(int a_j=0; a_j < n; a_j++){
					a[a_i][a_j] = in.nextInt();
				}
			}

			System.out.println(diagonalDifference(a));
		} 
	}
}
