/**
 * 
 */
package com.austinarbor.solutions.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Austin
 *
 */
public class UtopianTree {
	public static List<Integer> heights;
	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		heights = new ArrayList<Integer>();
		heights.add(1);
		Scanner s = new Scanner(System.in);
		int numLines = s.nextInt();
		for(int i=0; i < numLines;i++) {
			int yrs = s.nextInt();
			if(heights.size()-1 < yrs) {
				for(int j= heights.size()-1; j<yrs;j++) {
					if((j+1)%2==0) {
						heights.add(heights.get(j)+1);
					} else {
						heights.add(heights.get(j)*2);
					}
				}
			}
			System.out.println(heights.get(yrs));
		}
		s.close();
	}
}
