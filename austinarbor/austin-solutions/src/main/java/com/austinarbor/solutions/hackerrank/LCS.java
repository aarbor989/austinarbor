package com.austinarbor.solutions.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.austinarbor.solutions.AbstractSolution;
import com.austinarbor.solutions.SolutionsRunner;
import com.austinarbor.solutions.annotation.RunnableSolution;

/**
 * <b>The Longest Common Subsequence</b>
 * <p>A subsequence is a sequence that can be derived from another sequence 
 * by deleting some elements without changing the order of the remaining elements. 
 * Longest common subsequence (LCS) of 2 sequences is a subsequence, with maximal length, 
 * which is common to both the sequences. 
 * <p>Given two sequences of integers, <b><i>A</i></b>=[a1,a2...,an] and <b><i>B></i></b>=[b1,b2,...,bm]
 * find <b>any one</b> longest common subsequence.
 * <p>In case multiple solutions exist, print any of them.  It is guaranteed that at least one non-empty
 * common subsequence will exist.
 * <p><b>Recommended References</b><br>
 * <a href="https://youtu.be/V5hZoJ6uK-s">Youtube Video Tutorial</a>
 * <p><b>Input Format</b><br>
 * First line contains two space separated integers, <b><i>n</i></b> and <b><i>m</i></b>,
 * where <b><i>n</i></b> is the size of sequence <b><i>A</i></b>, while <b><i>m</i></b> 
 * is the size of the sequence <b><i>B</i></b>. In next line there are <b><i>n</i></b>space 
 * separated integers representing sequence <b><i>A</i></b>, and in third line there are 
 * <b><i>m</i></b> space separated integers representing sequence <b><i>B</i></b>.
 * <p><b>Constraints</b><br>
 * 1 <= <i>n</i> <= 100<br>
 * 1 <= <i>m</i> <= 100<br>
 * 0 <= <i>ai</i> <= 1000, <i>where i</i>  element of [1,<i>n</i>]<br>
 * 0 <= <i>bj</i> <= 1000, <i>where j</i>  element of [1,<i>m</i>]
 * <p><b>Output Format</b><br>
 * Print the longest common subsequence and each element should be separated by at 
 * least one white-space. In case of multiple answers, print any one of them.
 * @author Austin G. Arbor
 * @see <a href="https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence">HackerRank Longest Common Subsequence</a>
 *
 */
@RunnableSolution
public class LCS extends AbstractSolution {
	
	private static final transient Logger LOGGER = LoggerFactory.getLogger(LCS.class);
	
	public LCS() {
		super(LCS.class.getSimpleName());
	}

	public static void lcs(char[] A, char[] B) {
		if(A == null || A.length ==0){
			System.out.println(0);
			return;
		}
		if(B == null || B.length == 0){
			System.out.println(0);
			return;
		}
		
		int[][] lcs = new int[A.length+1][B.length+1];
		for(int i=1; i <= A.length; i++) {
			for(int j=1; j <= B.length; j++) {
				if(A[i-1] == B[j-1]) {
					lcs[i][j] = 1 + lcs[i-1][j-1];
				} else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
	}

	@Override
	public void doRun(Scanner scanner) {
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] A = new int[n];
		int[] B = new int[m];
		LOGGER.info("N: {}",n);
		LOGGER.info("M: {}",m);
		for(int i=0;i < n; i++) {
			A[i] = scanner.nextInt();
		}
		for(int i=0; i < m; i++) {
			B[i] = scanner.nextInt();
		}
		LOGGER.info("A: {}",Arrays.toString(A));
		LOGGER.info("B: {}",Arrays.toString(B));
		printLcs(A,B);
		
	}
	
	
	public void printLcs(int[] A, int[] B) {
		
		int[][] table = getLcsTable(A,B);
		
		//List<Integer> resultList = new ArrayList<Integer>();
		int[] lcsArr = new int[table[A.length][B.length]];
		int i = A.length, j = B.length;
		int itr = lcsArr.length-1;
		while(i >0 && j > 0) {
			if(A[i-1] == B[j-1]) {
				lcsArr[itr--] = A[i-1];
				//resultList.add(A[i-1]);
				i--;
				j--;
			} else if(table[i-1][j] < table[i][j-1]) {
				j--;
			} else {
				i--;
			}
		}
		for(int y=0; y < lcsArr.length; y++) {
			System.out.print(lcsArr[y]);
			if( y < lcsArr.length -1) {
				System.out.print(" ");
			}
		}
		//StringBuffer lcs = new StringBuffer();
		/*for(int x = resultList.size()-1; x >=0; x--) {
			System.out.print(resultList.get(x));
			lcs.append(resultList.get(x));
			if(x > 0) {
				System.out.print(" ");
				lcs.append(" ");
			}
		}*/
		LOGGER.info("LCS of A and B is {}",Arrays.toString(lcsArr));
	}
	
	public int[][] getLcsTable(int[] A, int[] B) {
		int[][] table = new int[A.length+1][B.length+1];
		for(int i=1; i <= A.length; i++) {
			for(int j=1; j <= B.length; j++) {
				if(A[i-1] == B[j-1]) {
					table[i][j] = 1 + table[i-1][j-1];
				} else {
					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
				}
			}
		}
		
		return table;
	}
	
	public int getLcsLength(int[] A, int[] B) {
		int[][] table = getLcsTable(A,B);
		LOGGER.info("Length of the LCS of A and B is {}", table[A.length][B.length]);
		System.out.println(table[A.length][B.length]);
		return table[A.length][B.length];
	}
	
	public static void main(String[] args) {
		SolutionsRunner sr = new SolutionsRunner(LCS.class.getName());
		sr.runSolutions();
	}

}
