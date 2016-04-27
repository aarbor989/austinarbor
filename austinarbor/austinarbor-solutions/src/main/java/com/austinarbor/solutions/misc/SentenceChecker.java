package com.austinarbor.solutions.misc;

import java.util.HashSet;

public class SentenceChecker {

    public static boolean isSentence(String s, HashSet<String> d) {
        boolean sentence = false;
        StringBuilder buf = new StringBuilder();
        String cur="";
        int idx=-1;
        int endIdx=-1;
        for(int i = s.length()-1; i >=0; i--) {
           // System.out.println("Current letter: " +s.charAt(i));
            cur = s.charAt(i) + cur;
            //buf = new StringBuilder(s.charAt(i)).append(buf);
           // System.out.println(cur);
            if(!d.contains(cur) && i==0 && idx == -1) {
                return false;
            }
            else if(!d.contains(cur) && i==0 && idx != -1) {
               // System.out.println("Retracing steps: idx: " + idx);
                i= idx;
                cur = s.substring(idx, endIdx);
                idx = -1;
                endIdx=-1;
                //System.out.println("cur: " + cur);
            }
            else if(d.contains(cur)) {
                idx = i;
                endIdx = i + cur.length();
                sentence = true;
                cur="";
            }
        }
        //System.out.println("Sentence: " + sentence);
        return sentence;
    }
    
    
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        HashSet<String> dictionary=new HashSet<String> ();
        dictionary.add("I");
        dictionary.add("LOVE");
        dictionary.add("TO");
        dictionary.add("EAT");
        dictionary.add("TACOS");
        dictionary.add("MEET");
        dictionary.add("ME");
        dictionary.add("THERE");
        dictionary.add("HERE");
        //dictionary.add("S");
        
        
        String s1="ILOVT";
        //String s="IIIIIIIIIIILOVETOEATTACOSSSSSSSSSSS";
        String s="THERESMEETMETHERE";
        

        
        System.out.println(isSentence(s,dictionary));
    }
}
