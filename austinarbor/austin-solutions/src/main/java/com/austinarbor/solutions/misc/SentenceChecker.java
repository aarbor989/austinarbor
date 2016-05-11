package com.austinarbor.solutions.misc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.austinarbor.solutions.AbstractSolution;

public class SentenceChecker extends AbstractSolution {
	/**
	 * Dictionary to store set of valid words to check 
	 * input strings against
	 */
	private Set<String> dictionary;
	
	public SentenceChecker() {
		super(SentenceChecker.class.getSimpleName());
	}
	
	/**
	 * Checks whether the input string <code>s</code> is a valid 'sentence'
	 * or not.  The input string should not have any spaces, and will be 
	 * validated against the dictionary defined in this class
	 * @param s The string to test
	 * @param dictionary The dictionary to check the string against
	 * @return True if the string is a sentence, false otherwise
	 */
    public boolean isSentence(String s, Set<String> dictionary) {
        boolean sentence = false;
       // StringBuilder buf = new StringBuilder();
        String cur="";
        int idx=-1;
        int endIdx=-1;
        for(int i = s.length()-1; i >=0; i--) {
           // System.out.println("Current letter: " +s.charAt(i));
            cur = s.charAt(i) + cur;
            //buf = new StringBuilder(s.charAt(i)).append(buf);
           // System.out.println(cur);
            if(!dictionary.contains(cur) && i==0 && idx == -1) {
                return false;
            }
            else if(!dictionary.contains(cur) && i==0 && idx != -1) {
               // System.out.println("Retracing steps: idx: " + idx);
                i= idx;
                cur = s.substring(idx, endIdx);
                idx = -1;
                endIdx=-1;
                //System.out.println("cur: " + cur);
            }
            else if(dictionary.contains(cur)) {
                idx = i;
                endIdx = i + cur.length();
                sentence = true;
                cur="";
            }
        }
        //System.out.println("Sentence: " + sentence);
        return sentence;
    }
    
    private void createDictionary() {
    	if((dictionary == null) ||(dictionary.isEmpty())) {
    		dictionary=new HashSet<String> ();
            dictionary.add("I");
            dictionary.add("LOVE");
            dictionary.add("TO");
            dictionary.add("EAT");
            dictionary.add("TACOS");
            dictionary.add("MEET");
            dictionary.add("ME");
            dictionary.add("THERE");
            dictionary.add("HERE");
    	}
    }
    
	@Override
	public void doRun(final Scanner scanner) {
		createDictionary();
		while(scanner.hasNextLine()) {
			final String input = scanner.nextLine();
			LOGGER.info("{} is sentence: {}",input,isSentence(input,dictionary));
			System.out.println(isSentence(input,dictionary));
		}
		
	}
}
