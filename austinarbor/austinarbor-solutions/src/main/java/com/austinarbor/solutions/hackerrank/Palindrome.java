/**
 * 
 */
package com.austinarbor.solutions.hackerrank;

import java.util.Scanner;

/**
 * @author Austin
 *
 */
public class Palindrome {
	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner sc = new Scanner(System.in);
		int numLines = sc.nextInt();
		for(int i=0; i < numLines; i++) {
			char[] charArray = sc.next().toCharArray();
			//char[] charArray = "hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcwflvsgygh".toCharArray();
			int index = -1;
			for(int j=0, x=charArray.length-1; j<=x && x>=j;j++,x--) {
				if(charArray[j] == charArray[x]) {
					continue;
				} else {
					boolean found = false;
					if(charArray[j+1] == charArray[x]) {
						if((j+2) <= (x-1)) {
							if(charArray[j+2] == charArray[x-1]) {
								index = j;
								found=true;
								break;
							}
						} else {
							found=true;
							index = j;
							break;
						}
					}
					if (!found) {
						index = x;
						break;
					}
				}
			}
			System.out.println(index);
		}
	}
}

