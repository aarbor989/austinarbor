/**
 * 
 */
package com.austinarbor.solutions.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Austin
 *
 */
public class Sherlock {
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		 	
	        //Scanner scanner = new Scanner(System.in);
	        //String str = scanner.next();
		 String str = "hfchdkkbfifgbgebfaahijchgeeeiagkadjfcbekbdaifchkjfejckbiiihegacfbchdihkgbkbddgaefhkdgccjejjaajgijdkd";
	        Map<Character,Integer> charCount = new HashMap<Character,Integer>();
	        int firstCount=-1;
	        int firstCountCount=0;
	        int secondCountCount=0;
	        int secondCount=-1;
	        int numRems = 0;
	        for(int i=0; i < str.length(); i++) {
	            char c = str.charAt(i);
	            if(charCount.containsKey(c)) {
	                charCount.put(c, charCount.get(c)+1);
	            } else {
	                charCount.put(c,1);
	            }
	        }
	        for(Character c : charCount.keySet()) {
	            int count = charCount.get(c);
	            System.out.println("Char: " + c+ "\tCount: " + count);
	            if (firstCount == -1) {
	                firstCount=count;
	                firstCountCount++;
	            } else if (count != firstCount && secondCount == -1) {
	                secondCount = count;
	                secondCountCount++;
	                numRems++;
	                if(numRems > 1) {
	                	 System.out.println("NO");
		                 return;
	                }
	            } else if (count == firstCount && secondCount == -1) {
	            	continue;
	            }else if(count == firstCount || (count == secondCount && secondCount!= -1)) {
	               if(count == firstCount) {
	            	   firstCountCount++;
	               } else {
	            	   secondCountCount++;
	               }
	               if(firstCountCount >1 && secondCountCount > 1) {
	            	   System.out.println("NO");
	                    return;
	               }
	            	/*numRems++;
	                if(numRems > 1) {
	                    System.out.println("NO");
	                    return;
	                }
	                if(count != firstCount) {
	                	firstCount=secondCount;
	                	secondCount=-1;
	                }*/
	            } else if(count != firstCount && count != secondCount) {
	               System.out.println("NO");
	               return;
	            }
	        }
	        System.out.println("YES");
	    }
}
