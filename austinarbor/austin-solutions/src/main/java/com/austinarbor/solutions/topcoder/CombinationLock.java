package com.austinarbor.solutions.topcoder;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class CombinationLock{
	private static final Logger logger = Logger.getLogger(CombinationLock.class);
	
    public double degreesTurned(int[] combo, int size, int start) {
       return degreesTurned(combo, size, start, "COUNTER", 0.0);        
    }
    
    public double degreesTurned(int[] combo, int size, int start, String direction, double total) {
       logger.info("Combo: " + combo.toString());
    	if(combo.length ==0) {
            return total;
        } 
    	else {
            double initialRot = (combo.length*360.00);
            logger.info("initialRot: " + initialRot);
            int dist = calcDiff(start, combo[0], size, direction);
           // logger.info("Dist between nums " + start + " and " + combo[1] + " is: " + dist);
            double distDeg = dist*(360.00/size);
            logger.info("Dist in degrees: " + distDeg);
            total+=initialRot+distDeg;
            logger.info("Total: " + total);
            if(combo.length ==1) {
            	return total;
            }
            else {
            int[] newCombo= Arrays.copyOfRange(combo, 1, combo.length);
            String newDir = direction.equalsIgnoreCase("COUNTER") ? "CLOCK" : "COUNTER";
            return degreesTurned(newCombo, size, combo[0], newDir, total);
            }
        }   	
    }
    
    private int calcDiff(int start, int dest, int size, String direction) {
        if(direction.equalsIgnoreCase("COUNTER")) {
            if(dest > start) {
            	return dest-start;
            }
            else {
               return ((size-start)+dest);
            }
        } 
        else {
            if(dest < start) {
                return start-dest;
            } 
            else {
                return (start+(size-dest));
            }
        }
        
    }
    
    public static void main(String[] args) {
    	CombinationLock lock = new CombinationLock();
    	int[] combo = {10,20,30};
    	int size=40;
    	int start=6;
    	double degrees = lock.degreesTurned(combo, size, start);
    	System.out.println("Deg Turned: " + degrees);
    }
}