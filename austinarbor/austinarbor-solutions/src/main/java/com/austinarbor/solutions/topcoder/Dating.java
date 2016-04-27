package com.austinarbor.solutions.topcoder;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.experimental.theories.Theories;

import com.austinarbor.solutions.AbstractSolution;
import com.austinarbor.solutions.Solution;

import java.util.PriorityQueue;
public class Dating {
    
    private PriorityQueue<Character> girls;
    private PriorityQueue<Character> guys;
    private Queue<Character> circleQ;
    //private StringBuilder dates;
    
    public String dates(String circle, int k) {
       circleQ = new LinkedList<Character>();
       
    	girls = new PriorityQueue<Character>();
        guys = new PriorityQueue<Character>();
        int newK = k;
        if (newK > circle.length()) {
        	newK = k%circle.length();
        }
        for(int i=newK-1; i < circle.length(); i++) {
            if(circle.charAt(i) == Character.toUpperCase(circle.charAt(i))) {
               guys.add(circle.charAt(i)); 
            } else {
               girls.add(circle.charAt(i));
            }
            circleQ.add(circle.charAt(i));
        }
        if(k >1) {
        	for(int i=0; i < newK-1; i++) {
                if(circle.charAt(i) == Character.toUpperCase(circle.charAt(i))) {
                    guys.add(circle.charAt(i)); 
                 } else {
                    girls.add(circle.charAt(i));
                 }
                 circleQ.add(circle.charAt(i));
        	}
        }
       // System.out.println(circleQ.toString());
        
        return dates(circleQ, k, new StringBuilder());
    }
    
    private String dates(Queue<Character> circle, int k, StringBuilder sbdates) {
    	if (circle.size() == 1) {
    		return sbdates.deleteCharAt(sbdates.length()-1).toString();
    	}
    	else {
    		char chooser = circle.remove();
    		sbdates.append(chooser);
    		if(Character.toUpperCase(chooser) == chooser) {
    			char c = girls.remove();
    			sbdates.append(c);
    			circle.remove(c);
    		} else {
    			char c = guys.remove();
    			sbdates.append(c);
    			circle.remove(c);
    		}
    		
     		for(int i=0; i < k-1; i++) {
    			
    			char c= circle.remove();
    			//System.out.println("Moving: " + c);
    			if (c == sbdates.charAt(sbdates.length()-1)) {
    				//System.out.println(c + " Equals chosen, re-doing");
    				c = circle.remove();
    			}
    			circle.add(c);
    		}
    	
    		sbdates.append(" ");
    		return dates(circle, k, sbdates);
    	}
    }

    public static void main(String args[]) {
    	Dating d = new Dating();
    	String res = d.dates("abXCd", 2);
    	System.out.println(res);
    }
    
}
