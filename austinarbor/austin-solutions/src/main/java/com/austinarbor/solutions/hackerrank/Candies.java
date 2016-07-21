package com.austinarbor.solutions.hackerrank;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.austinarbor.solutions.AbstractSolution;
import com.austinarbor.solutions.SolutionsRunner;
import com.austinarbor.solutions.annotation.RunnableSolution;

@RunnableSolution
public class Candies extends AbstractSolution {

	private static final transient Logger LOGGER = LoggerFactory.getLogger(Candies.class);
	
	public Candies() {
		super(Candies.class.getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doRun(Scanner scanner) {
		int N = scanner.nextInt();
		LOGGER.info("Number of students: {}", N);
		int[] students = new int[N];
		int[] candies = new int[N];
		for(int i=0; i < N;i++) {
			students[i] = scanner.nextInt();
		}
		candies[0] = 1;
		int sum=1;
		for(int i=1; i < students.length;i++) {
			if(students[i] > students[i-1]) {
				candies[i] = candies[i-1] +1;
			} else {
				candies[i] = 1;
			}
		}
		sum = candies[candies.length-1];
		for(int i =N-2; i >=0; i--) {
			if(students[i] > students[i+1] && candies[i] <= candies[i+1]) {
				candies[i] = candies[i+1]+1;
			} 
			sum+=candies[i];
		}
		LOGGER.info("Minimum number of candies: {}",sum);
		System.out.println(sum);
		
	}
	
	public static void main(String[] args) {
		SolutionsRunner sr = new SolutionsRunner(Candies.class.getName());
		sr.runSolutions();
	}

}
