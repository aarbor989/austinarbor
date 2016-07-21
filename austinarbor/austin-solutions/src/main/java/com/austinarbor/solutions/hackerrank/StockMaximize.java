package com.austinarbor.solutions.hackerrank;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.austinarbor.solutions.AbstractSolution;
import com.austinarbor.solutions.SolutionsRunner;
import com.austinarbor.solutions.annotation.RunnableSolution;

@RunnableSolution
public class StockMaximize extends AbstractSolution {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StockMaximize.class);
	
	public StockMaximize() {
		super(StockMaximize.class.getSimpleName());
	}

	@Override
	public void doRun(Scanner scanner) {
		int T = scanner.nextInt();
		for(int i=0; i < T; i++) {
			//System.out.println(i);
			int N = scanner.nextInt();
			int[] prices = new int[N];
			int profit=0;
			for(int j=0; j < N; j++) {
				prices[j] = scanner.nextInt();
			}
			int max=0;
			for(int x= prices.length -1 ; x>=0; x--) {
				if(prices[x] >= max) {
					max = prices[x];
				}
				profit+= max - prices[x];
			}
			System.out.println(profit);
		}
		
	}
	
	public static void main(String[] args) {
		SolutionsRunner sr = new SolutionsRunner(StockMaximize.class.getName());
		sr.runSolutions();
	}

}
