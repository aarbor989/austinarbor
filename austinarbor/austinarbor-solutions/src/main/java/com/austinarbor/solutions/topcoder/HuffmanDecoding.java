package com.austinarbor.solutions.topcoder;

public class HuffmanDecoding {
	
    public static final int a = (int)'A';
    
    public String decode(String archive, String[] dictionary) {
       String res="";
        String[] chars = new String[dictionary.length];
        for(int i=0; i < chars.length; i++) {
            chars[i] = Character.toString((char)(a+i));
        }
        String curTest = "";
        for (int i=0; i < archive.length(); i++) {
          curTest = curTest + archive.charAt(i);
            for(int j=0; j< dictionary.length; j++) {
                if(curTest.equals(dictionary[j])){
                    res = res+chars[j];
                    curTest="";
                } 
            }
        }
        return res;
    }
    
    public static void main(String args[]) {
    	HuffmanDecoding h = new HuffmanDecoding();
    	String archive="101101";
    	String[] dictionary = {"00","10","01","11"};
    	String res =h.decode(archive, dictionary);
    	System.out.println(res);
    }

}
