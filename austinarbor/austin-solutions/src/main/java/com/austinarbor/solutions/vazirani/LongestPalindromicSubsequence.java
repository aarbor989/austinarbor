package com.austinarbor.solutions.vazirani;

public class LongestPalindromicSubsequence {
	
	public static void main(String[] args) {
		char[] sequence = {'A','C','G','T','G','T','C','A','A','A','A','T','C','G'};
		System.out.println(longestPalindrome(sequence));
	}
	
	public static int longestPalindrome(char[] sequence) {
		int L[][] = new int[sequence.length][sequence.length];
		for(int i=0; i < sequence.length; i++) {
			L[i][i] = 1;
		}
		for(int cl=2; cl <= sequence.length; cl++) {
			for(int i=0; i < sequence.length-cl+1; i++) {
				int j = i+cl-1;
				if(sequence[i] == sequence[j] && cl==2) {
					L[i][j] =2;
				} else if (sequence[i] == sequence[j]) {
					L[i][j] = L[i+1][j-1]+2;
				} else {
					L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
				}
			}
		}
		return L[0][sequence.length-1];
	}
	

}
