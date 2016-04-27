package com.austinarbor.solutions.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to find the first non-repeated
 * character of a string
 * @author Austin G. Arbor
 *
 */
public class NonRepeatedChar {
	
	private static final String str="teeter";
	
	public static void main(String args[]) {
		Character c = firstNonRepeated(str);
		System.out.println(c);
	}
	
	public static Character firstNonRepeated(String str) {
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

}
