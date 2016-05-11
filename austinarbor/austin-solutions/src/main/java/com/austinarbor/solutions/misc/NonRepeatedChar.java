package com.austinarbor.solutions.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.austinarbor.solutions.AbstractSolution;

/**
 * Class to find the first non-repeated
 * character of a string
 * @author Austin G. Arbor
 *
 */
public class NonRepeatedChar extends AbstractSolution {

	private static final Logger LOGGER = LoggerFactory.getLogger(NonRepeatedChar.class);

	public NonRepeatedChar() {
		super(NonRepeatedChar.class.getSimpleName());
	}

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
	public void doRun(final Scanner scanner) {
		while(scanner.hasNextLine()) {
			final String input = scanner.nextLine();
			Character c = firstNonRepeated(input);
			LOGGER.info("First Non-Repeated Character in String \"{}\" is '{}'",input,c);
		}
	}

}
