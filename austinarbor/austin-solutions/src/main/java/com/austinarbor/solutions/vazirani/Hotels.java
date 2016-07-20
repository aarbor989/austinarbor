package com.austinarbor.solutions.vazirani;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Problem 6.2 from Chapter 6
 * @author Austin G. Arbor
 * @see <a href="https://people.eecs.berkeley.edu/~vazirani/algorithms/chap6.pdf">Vazirani</a>
 */
public class Hotels {
	public static void main(String[] args) {
		int[] hotels = {200, 400, 600, 800, 1000};
		System.out.println(minCost(hotels));
	}
	
	public static int minCost(int[] hotels) {
		int[] C = new int[hotels.length];
		C[0] = cost(hotels[0]);
		Set<Integer> solution = new LinkedHashSet<>();
		for(int i=1; i < hotels.length; i++) {
			C[i] = cost(hotels[i]);
			int tmpBest=-1;
			for(int j=0; j < i; j++) {
				int cost = C[j] + cost(hotels[i]-hotels[j]);
				if (cost < C[i]) {
					C[i] = cost;
					tmpBest=j;
				}
			}
			solution.add(tmpBest);
		}
		solution.add(hotels.length-1);
		System.out.println(Arrays.toString(C));
		System.out.println(Arrays.toString(solution.toArray()));
		return C[hotels.length-1];
	}
	
	public static int cost(int dist) {
		return (int)Math.pow(200-dist,2);
	}
}
