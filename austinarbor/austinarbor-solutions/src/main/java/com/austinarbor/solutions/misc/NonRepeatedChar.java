package com.austinarbor.solutions.misc;

import java.util.HashMap;
import java.util.Map;

import com.austinarbor.solutions.AbstractSolution;

/**
 * Class to find the first non-repeated
 * character of a string
 * @author Austin G. Arbor
 *
 */
public class NonRepeatedChar extends AbstractSolution {
	
	
	public Character firstNonRepeated(String str) {
		Character res = null;//str.charAt(0);
		Map<Character, Integer> charMap = new HashMap<Character,Integer>();
		for (int i=0; i < str.length(); i++) {
			if(charMap.containsKey(str.charAt(i))) {
				charMap.put(str.charAt(i), charMap.get(str.charAt(i)+1));
				if(res!=null && str.charAt(i) == res) {
					res = null;
				}
			} else {
				charMap.put(str.charAt(i), 1);
				if(res == null) {
					res = str.charAt(i);
				}
			}
		}
		return res;
	}
	
	@Override
	public void run() {
		NonRepeatedChar nrc = new NonRepeatedChar();
		final String testStr = "teeter";
		Character c = nrc.firstNonRepeated(testStr);
		System.out.println("First Non-Repeated Character in String \"" + testStr+"\" " + c);
	}

}
