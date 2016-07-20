package com.austinarbor.solutions.topcoder;

public class AdditionCycles {
    public int cycleLength(int n) {
        int x = n;
        int orig = n;
        int count=0;
        do {
            x = add(n);
            x=combine(n,x);
            n=x;
            count++;
            } while(x != orig);
        return count;
     }
    
    public int add(int num) {
     	if(num < 10) {
            return num;
         }
        else {
           String strNum = Integer.toString(num);
            return Integer.parseInt(strNum.substring(0,1)) + Integer.parseInt(strNum.substring(1));
            }
     }
    
    public int combine(int num1, int num2) {
        	String strNum1 = num1<10 ? "0" + Integer.toString(num1) : Integer.toString(num1);
        	String strNum2 = num2<10 ? "0" + Integer.toString(num2) : Integer.toString(num2);
        	String newNum = strNum1.substring(1) + strNum2.substring(1);
        	return Integer.parseInt(newNum);
        }
    
 }
