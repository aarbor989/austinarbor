/**
 * 
 */
package com.austinarbor.solutions.hackerrank;

import java.util.Scanner;

/**
 * @author Austin
 *
 */
public class MaxSubArray {
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner scanner = new Scanner(System.in); 
	        int T = scanner.nextInt();
	        for(int i=0; i < T; i++) {
	            int max;
	            int anyMax=0;
	            int maxElem;
	            int N = scanner.nextInt();
	            int[] work = new int[N];
	            work[0] = scanner.nextInt();
	            max=work[0];
	            maxElem = work[0];
	            anyMax = (maxElem >=0) ? maxElem : 0;
	            for(int x=1; x < N; x++) {
	                int num  = scanner.nextInt();
	                work[x] = Math.max(num, num+work[x-1]);
	                max = Math.max(work[x],max);
	                if(num > 0) {
	                    anyMax +=num;
	                }
	                if(num > maxElem) {
	                    maxElem = num;
	                }
	            }
	            if(anyMax < 0) {
	                anyMax = maxElem;
	            }
	            System.out.println(max + " " + anyMax);
	        }
	        
	    }
}
