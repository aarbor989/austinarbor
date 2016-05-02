/**
 * 
 */
package com.austinarbor.solutions.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.austinarbor.solutions.AbstractSolution;
import com.austinarbor.solutions.annotation.RunnableSolution;

/**
 * <p>You know my powers, my dear Watson, and yet at the end of three months I was forced 
 * to confess that I had at last met an antagonist who was my intellectual equal. 
 * A "valid" string is a string S such that for all distinct characters in S each such 
 * character occurs the same number of times in S.
 * <p>For example, aabb is a valid string because the frequency of both characters a and b is 2,
 * whereas aabbc is not a valid string because the frequency of characters a, b, and c is not the same.
 * <p>Watson gives a string S to Sherlock and asks him to remove some characters from the string such 
 * that the new string is a "valid" string.
 * <p>Sherlock wants to know from you if it's possible to be done with less than or equal to one removal.
 * <p><b>Input Format</b><br/>
 * The first and only line contains SS, the string Watson gives to Sherlock.
 * <p><b>Output Format</b><br/>
 * Output YES if string S can be converted to a "valid" string by removing less than or equal to one character. 
 * Else, output NO.
 * <p><b>Constraints:</b><br/>
 * 1 <= size of string S <= 10^5<br/>
 * String SS contains lowercase letters (a-z) only.
 * @author Austin G. Arbor
 * @see <a href="https://www.hackerrank.com/challenges/sherlock-and-valid-string">HackerRank Sherlock and Valid String </a>
 */
@RunnableSolution
public class SherlockAndValidStrings extends AbstractSolution{
	private static final Logger LOGGER = LoggerFactory.getLogger(SherlockAndValidStrings.class);
	
	public SherlockAndValidStrings() {
		super(SherlockAndValidStrings.class.getSimpleName());
	}
	
	public boolean isValidString(final String str) {
		LOGGER.info("BEGIN");
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
			LOGGER.info("Char: " + c+ "\tCount: " + count);
			if (firstCount == -1) {
				firstCount=count;
				firstCountCount++;
			} else if (count != firstCount && secondCount == -1) {
				secondCount = count;
				secondCountCount++;
				numRems++;
				if(numRems > 1) {
					return false;
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
					//System.out.println("NO");
					return false;
				}
			} else if(count != firstCount && count != secondCount) {
				//System.out.println("NO");
				return false;
			}
		}
		//System.out.println("YES");
		LOGGER.info("END");
		return true;
	}

	@Override
	public void run() {
		File[] inputFiles = getInputFiles();
		SherlockAndValidStrings sherlock = new SherlockAndValidStrings();
		for(int i=0; i < inputFiles.length; i++) {
			final File file = inputFiles[i];
			try(final Scanner scanner = new Scanner(file)) {
				while(scanner.hasNextLine()) {
					final String line = scanner.nextLine();
					LOGGER.info("Testing string " + line);
					if(sherlock.isValidString(line)) {
						LOGGER.info("{} is a valid string!",line);
						System.out.println("YES");
					} else {
						LOGGER.info("{} is not a valid string",line);
						System.out.println("NO");
					}
				}
			} catch (FileNotFoundException e) {
				LOGGER.error("Exception while trying to open file {}",file.getName());
			}
		}
		
	}
}
