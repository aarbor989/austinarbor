package com.austinarbor.solutions.topcoder;

import java.util.Map;
import java.util.HashMap;

public class FolderSize {
    public int[] calculateWaste(String[] files, int folderCount, int clusterSize) {
        Map<Integer, Integer> fileMap = new HashMap<Integer, Integer>();
        int[] results=new int[folderCount];
        for (int i=0; i < files.length; i++) {
            String[] splitStr = files[i].split(" ");
            int idx = Integer.parseInt(splitStr[0]);
            int size = Integer.parseInt(splitStr[1]);
            if (fileMap.containsKey(idx)) {
                int tmp = (int)fileMap.get(idx);
                tmp+=size;
                 fileMap.put(idx,size);   
            } else {
                fileMap.put(idx, size);
            }
            for (int j=0; j < folderCount; j++) {
               
                if (fileMap.containsKey(j)) {
                    double wastedSpace=0;
                    int totalSize = (int)fileMap.get(j);
                    double requiredClusters = Math.ceil(totalSize / clusterSize);
                    double usedSpace = clusterSize * requiredClusters;
                    wastedSpace = Math.abs(usedSpace - (clusterSize * requiredClusters));
                    results[j] = (int)wastedSpace;
                }
                else {
                   results[j] = 0; 
                }
            }

        }
        
        return results;
    }
    
    public static void main(String args[]) {
    	FolderSize fs = new FolderSize();
    	String[] files = {"0 25", "0 20", "1 25"};
    	int[] waste = fs.calculateWaste(files, 3, 50);
    	for (int i=0; i < waste.length; i++) {
    		System.out.println(waste[i]);
    	}
    }
    
}