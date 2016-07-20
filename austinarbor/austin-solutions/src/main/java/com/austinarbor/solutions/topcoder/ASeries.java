package com.austinarbor.solutions.topcoder;
import java.util.*;
public class ASeries {
	
	public static void main(String[] args) {
		ASeries a = new ASeries();
		int[] values = {3,8,4,5,6,2,2};
		a.longest(values);
	}

	public int longest(int[] values) {
		Map<Integer,List<Integer>> counts = new HashMap<Integer,List<Integer>>();
		Arrays.sort(values);
		int maxCount=0;
		int maxDiff=0;
		Set<Integer> set = new LinkedHashSet<Integer>();
		Map<Integer,Integer> dupSet = new HashMap<Integer,Integer>();
		for(int i : values) {
			if(set.contains(i)) {
				if(dupSet.containsKey(i)) {
					dupSet.put(i, dupSet.get(i)+1);
				} else {
					dupSet.put(i, 2);
				}
				if(dupSet.get(i) > maxCount) {
					maxCount = dupSet.get(i);
					maxDiff=0;
				}
			}
			set.add(i);
		}
		Integer[] setArr =  set.toArray(new Integer[set.size()]);
		//System.out.println(Arrays.toString(setArr));
		for(int i=0; i < setArr.length; i++) {
			for(int j=i+1; j < setArr.length; j++) {
				//System.out.println("Comparing " + setArr[i] + " and " + setArr[j] + " => " + (setArr[j] - setArr[i]));
				int diff = setArr[j] - setArr[i];
				//int diffCount =1;
				int num = setArr[j];
				List<Integer> numbers = new ArrayList<Integer>();
				numbers.add(setArr[i]);
				while(set.contains(num)) {
					numbers.add(num);
					//diffCount++;
					num+=diff;
				}
				if(counts.containsKey(diff)) {
					if(counts.get(diff).size() < numbers.size()) {
						counts.put(diff, numbers);
					}
				} else {
					counts.put(diff, numbers);
				}
				
				//System.out.println("Diff " + diff + " had " + numbers.size() + " numbers: " + Arrays.toString(numbers.toArray()));
				
				if(numbers.size() > maxCount) {
					maxDiff = diff;
					maxCount = numbers.size();
				}
			}
		}
		//System.out.println("Most common diff: " + maxDiff);
		
		return maxCount;
	}

}
