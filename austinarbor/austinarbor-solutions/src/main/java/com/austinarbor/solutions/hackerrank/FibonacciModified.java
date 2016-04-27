/**
 * 
 */
package com.austinarbor.solutions.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Austin
 *
 */
public class FibonacciModified {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner s = new Scanner(System.in);
		BigInteger first = s.nextBigInteger();
		BigInteger second = s.nextBigInteger();
		int target = s.nextInt();
		BigInteger[] solutions = new BigInteger[target+1];
		solutions[0] = first;
		solutions[1] = second;
		for(int i=2; i < target; i++) {
			solutions[i] = (solutions[i-1].multiply(solutions[i-1])).add(solutions[i-2]);
		}

		System.out.println(solutions[target-1]);

	}

}
