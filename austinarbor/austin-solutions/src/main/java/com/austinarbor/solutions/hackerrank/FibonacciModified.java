/**
 * 
 */
package com.austinarbor.solutions.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.austinarbor.solutions.AbstractSolution;
import com.austinarbor.solutions.annotation.RunnableSolution;

/**
 * <p>A series is defined in the following manner:
 * <p>Given the nth and (n+1)th terms, the (n+2)th can be computed by the following relation <br/>
 * <pre>Tn+2 = (Tn+1)2 + Tn</pre>
 * So, if the first two terms of the series are 0 and 1: <br/>
 * the third term = 12 + 0 = 1 <br/>
 * fourth term = 12 + 1 = 2 <br/>
 * fifth term = 22 + 1 = 5 <br/>
 * ... And so on.
 * <p>Given three integers A, B and N, such that the first two terms of the series 
 * (1st and 2nd terms) are A and B respectively, compute the Nth term of the series.
 * <p><b>Input Format</b><br/>
 * You are given three space separated integers A, B and N on one line. <br/>
 * Input Constraints <br/>
 * 0 <= A,B <= 2 <br/>
 * 3 <= N <= 20 <br/>
 * <p><b>Output Format</b><br/>
 * One integer.<br/>
 * This integer is the Nth term of the given series when the first two terms are A and B respectively.
 * <p><b>Note</b><br/>
 * Some output may even exceed the range of 64 bit integer.
 * @author Austin G. Arbor
 * @see <a href="https://www.hackerrank.com/challenges/fibonacci-modified">HackerRank Fibonacci Modified</a>
 *
 */
@RunnableSolution
public class FibonacciModified extends AbstractSolution {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciModified.class);

	public FibonacciModified() {
		super(FibonacciModified.class.getSimpleName());
	}
	
	
	public BigInteger fibonacciModified(BigInteger first, BigInteger second, int target) {
		BigInteger[] solutions = new BigInteger[target+1];
		solutions[0] = first;
		solutions[1] = second;
		for(int i=2; i < target; i++) {
			solutions[i] = (solutions[i-1].multiply(solutions[i-1])).add(solutions[i-2]);
		}
		
		return solutions[target-1];
	}

	@Override
	public void run() {
		LOGGER.info("BEGIN");
		final File[] inputFiles = getInputFiles();
		for(File file : inputFiles) {
			try(final Scanner scanner = new Scanner(file)) {
				BigInteger first = scanner.nextBigInteger();
				BigInteger second = scanner.nextBigInteger();
				int target = scanner.nextInt();
				LOGGER.info("First Number: {}",first);
				LOGGER.info("Second Number: {}",second);
				LOGGER.info("Target Number: {}", target);
				BigInteger solution = fibonacciModified(first,second,target);
				LOGGER.info("Solution: {}", solution);
			}catch(FileNotFoundException fnfe) {
				LOGGER.error("Error opening file " + file.getName(), fnfe);
			}
		}		
		LOGGER.info("END");
		
	}

}
