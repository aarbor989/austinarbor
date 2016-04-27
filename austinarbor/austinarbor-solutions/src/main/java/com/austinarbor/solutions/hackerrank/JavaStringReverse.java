/**
 * 
 */
package com.austinarbor.solutions.hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author Austin
 *
 */
public class JavaStringReverse {
	public static void main(String[] args) {
		final String A = "java";
		
		for(int i=0, j= A.length()-1; i<=j && j>= i; i++,j--) {
			if(i==j) {
				System.out.println("Yes");
				break;
			} else if(A.charAt(i) != A.charAt(j)) {
				System.out.println("No");
				break;
			} else {
				continue;
			}
		}
		Map<String, Set<String>> set = new HashMap<String, Set<String>>();
		set.put("h", new HashSet<String>());
	}

}
