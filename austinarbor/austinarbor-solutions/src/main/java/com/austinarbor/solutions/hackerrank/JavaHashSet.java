/**
 * 
 */
package com.austinarbor.solutions.hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Austin
 *
 */
public class JavaHashSet {
	  public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner scanner = new Scanner(System.in);
	        Map<String, Set<String>> nameMap = new HashMap<String,Set<String>>();
	        int uniqueCount=0;
	        int rows = scanner.nextInt();
	        
	        System.out.println(scanner.next());
	        for(int i=0; i < rows; i++) {
	            String[] names = scanner.nextLine().split(" ");
	            if(!nameMap.containsKey(names[0])) {
	                Set<String> set = new HashSet<String>();
	                set.add(names[1]);
	                nameMap.put(names[0],set);
	                uniqueCount++;
	            }else {
	                if(nameMap.get(names[0]).contains(names[1])) {
	                    continue;
	                } else {
	                    nameMap.get(names[0]).add(names[1]);
	                    uniqueCount++;
	                }
	            }
	            System.out.println(uniqueCount);
	        }
	        scanner.close();
	    }
}
