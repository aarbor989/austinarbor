/**
 * 
 */
package com.austinarbor.solutions.hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.austinarbor.solutions.AbstractSolution;

/**
 * 
 * <p><b>Problem Description:</b><br/>
 * Given two strings aa and bb of equal length, what's the longest string (SS) 
 * that can be constructed such that it is a child of both?
 * <p>A string xx is said to be a child of a string yy if xx can be formed by deleting
 *  0 or more characters from yy. 
 * <p>For example, ABCD and ABDC has two children with maximum length 3, ABC and ABD.</p>
 * <p> Note that we will not consider ABCD as a common child because C doesn't occur 
 * before D in the second string. 
 * <p><b>Input format</b><br/>
 * Two strings, aa and bb, with a newline separating them. 
 * <p><b>Constraints</b> <br/>
 * All characters are upper cased and lie between ASCII values 65-90. 
 * The maximum length of the strings is 5000. 
 * <p><b>Output format</b><br/>
 * Length of string SS.
 * @author Austin G. Arbor
 * @see <a href="https://www.hackerrank.com/challenges/common-child">HackerRank Common Child</a>
 */
public class CommonChild extends AbstractSolution {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommonChild.class);

	protected String inputFileDirectory;

	public CommonChild() {
		super();
		inputFileDirectory = BASE_INPUT_PATH + this.getClass().getSimpleName();
	}

	public int getCommonChild(String x, String y) {
		int M = x.length();
		int N = y.length();

		// opt[i][j] = length of LCS of x[i..M] and y[j..N]
		int[][] opt = new int[M+1][N+1];

		// compute length of LCS and all subproblems via dynamic programming
		for (int i = M-1; i >= 0; i--) {
			for (int j = N-1; j >= 0; j--) {
				if (x.charAt(i) == y.charAt(j))
					opt[i][j] = opt[i+1][j+1] + 1;
				else 
					opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
			}
		}
		return opt[0][0];
	}


	public void run()  {
		LOGGER.info("BEGIN");
		CommonChild cc = new CommonChild();
		File inputDir = new File(this.getClass().getClassLoader().getResource(inputFileDirectory).getFile());
		File[] inputFiles = inputDir.listFiles();
		for(int i=0; i < inputFiles.length; i++) {
			final File file = inputFiles[i];
			LOGGER.info("Run: {}\tFile: {}",i,file.getName());
			try(Scanner scanner = new Scanner(file)){
				String x = scanner.next();
				String y = scanner.next();
				LOGGER.info("X: {}",x);
				LOGGER.info("Y: {}",y);
				int commonChild = cc.getCommonChild(x, y);
				LOGGER.info("Common Child: {}", commonChild);
			} catch (FileNotFoundException e) {
				LOGGER.error("Exception in run()",e);
			} 			
		}

		LOGGER.info("END");
	}

}
