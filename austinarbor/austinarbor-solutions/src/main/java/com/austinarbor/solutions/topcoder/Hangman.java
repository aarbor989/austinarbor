package com.austinarbor.solutions.topcoder;

import java.util.List;
import java.util.ArrayList;

class Hangman {
	public String guessWord(String feedback, String[] words) {
		List<String> res = new ArrayList<String>();
		for(String w : words) {
			boolean match=true;
			if(w.length() != feedback.length()) {
				match=false;
			}
			for(int i=0; i < w.length() && match; i++) {
				if(feedback.charAt(i) == '-') {
					continue;
				}else {
					if(feedback.charAt(i) != w.charAt(i)){
						match=false;
						break;
					}
				}
			}
			if(match) {
				res.add(w);
			}
		}
		if(res.size() ==1) {
			return res.get(0);
		} else {
			return "";
		}
	}
	
	public static void main(String args[]) {
		Hangman h = new Hangman();
		String[] words = {"ROSACEA", "GYROVAGUE", "SHACONIAN", "ALTITONANT", "BRACHIATION", "CERCOPITHECAN", "SCOLECOPHAGOUS", "RESISTENTIALISM", "SLUBBERDEGULLION",  "AICHMORHABDOPHOBIA", "SPECTOCLOACAPHOBIA", "ULTRACREPIDARIANISM", "HIPPOPOTOMONSTROSESQUIPEDALIAN", "CHARGOGGAGOGGMANCHAUGGAGOGGCHAUBUNAGUNGAMAUGG"};
		String res = h.guessWord("---H-O-H-B-OPHOB--", words);
		System.out.println(res);
		
	}
}
