package com.austinarbor.solutions.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.austinarbor.solutions.AbstractSolution;

/**
 * <p><b>Problem Description:</b><br/>
 * Given a square matrix of size N×N, calculate the absolute 
 * difference between the sums of its diagonals.
 * <p><b>Input Format</b><br/>
 * The first line contains a single integer, N. The next N lines 
 * denote the matrix's rows, with each line containing N space-separated 
 * integers describing the columns.
 * <p><b>Output Format</b><br/>
 * Print the absolute difference between the two sums of the matrix's diagonals as a single integer
 * <p><b>Sample Input:</b><br/>
 * <table>
 * <tr><td>3</td></tr>
 * <tr><td>11</td><td>2</td><td>4</td></tr>
 * <tr><td>4</td><td>5</td><td>6</td></tr>
 * <tr><td>10</td><td>8</td><td>-12</td></tr>
 * </table>
 * 
 * <p><b>Sample Output:</b><br/>
 * 15
 * 
 * @author Austin G. Arbor
 * @see <a href="https://www.hackerrank.com/challenges/diagonal-difference">HackerRank Diagonal Difference</a>
 *
 */
public class DiagonalDifference extends AbstractSolution {

	private static final Logger LOGGER = LoggerFactory.getLogger(DiagonalDifference.class);

	protected String inputFileDirectory;

	public DiagonalDifference() {
		super();
		inputFileDirectory = BASE_INPUT_PATH + this.getClass().getSimpleName();
	}

	public int diagonalDifference(int[][] a) {
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



	}

	@Override
	public void run() {
		LOGGER.info("BEGIN");
		DiagonalDifference dd = new DiagonalDifference();
		File inputDir = new File(this.getClass().getClassLoader().getResource(inputFileDirectory).getFile());
		File[] inputFiles = inputDir.listFiles();
		for(int i=0; i < inputFiles.length; i++) {
			final File file = inputFiles[i];

			try(final Scanner in = new Scanner(file)) {
				int n = in.nextInt();
				int a[][] = new int[n][n];
				for(int a_i=0; a_i < n; a_i++){
					for(int a_j=0; a_j < n; a_j++){
						a[a_i][a_j] = in.nextInt();
					}
				}
				LOGGER.info("Diagonal Difference: {}", dd.diagonalDifference(a));
			} catch(FileNotFoundException fnfe) {
				LOGGER.error("Exception trying to find diagonal difference", fnfe);
			}
		}
		LOGGER.info("END");
	}
	/*
	 * 	LOGGER.info("BEGIN");
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
	 */
}
