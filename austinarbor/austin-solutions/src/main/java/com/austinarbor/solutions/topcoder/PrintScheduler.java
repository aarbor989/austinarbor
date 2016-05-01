package com.austinarbor.solutions.topcoder;

public class PrintScheduler {
	
	public static void main(String args[]) {
		String[] threads = {"ABCDE"};
		String[] slices = {"0 20","0 21"}  ;
		System.out.println(getOutput(threads, slices));
	}
    
    public static String getOutput(String[] threads, String[] slices) {
        int[] curPos = new int[threads.length];
        for(int i=0; i < threads.length; i++) {
            curPos[i] = 0;
        }
        String res="";
        for(int j=0; j< slices.length; j++) {
        	//System.out.println(slices[j]);
            String curSlice = slices[j];
            String[] split = curSlice.split(" ");
            int curThread = Integer.parseInt(split[0]);
            int threadTime = Integer.parseInt(split[1]);
           
            int idx = curPos[curThread];
            for(int x=0; x < threadTime; x++) {
                if(idx > threads[curThread].length()-1) {
                 idx=0;
                }
           		res = res + Character.toString(threads[curThread].charAt(idx++));
                curPos[curThread] = idx;
            }
            
        }
        return res;
    }
    
}