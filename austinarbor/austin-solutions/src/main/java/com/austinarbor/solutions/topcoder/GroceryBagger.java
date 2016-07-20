package com.austinarbor.solutions.topcoder;

import java.util.*;

/**
 * @author Austin G. Arbor
 * @see <a href="https://arena.topcoder.com/#/u/practiceCode/1448/3193/3450/1/1448">GroceryBagger</a>
 */
public class GroceryBagger {
    
    public int minimumBags(int strength, String[] itemType) {
        int numBags=0;
    	Map<String,Integer> itemCount = new HashMap<String,Integer>();
        for(String str: itemType) {
            if(itemCount.containsKey(str)) {
            	itemCount.put(str, itemCount.get(str)+1);
            } else {
            	itemCount.put(str, 1);
            }
        }
        
        for(String item : itemCount.keySet()) {
        	int count = itemCount.get(item);
        	while(count > 0) {
        		numBags++;
        		count -= strength;
        	}
        }
        
        return numBags;
    }
}
