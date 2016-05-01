package com.austinarbor.solutions.topcoder;

public class RPN {

	private int[] stack;
	
	public static void main(String args[]) {
		RPN rpn = new RPN();
		int x = rpn.evaluate("1 2 - - +");
		System.out.println(x);
	}

	public int evaluate(String expr) {

		stack = new int[1];
		String eval= expr;
		for (int i=0; i < expr.length(); i++) {
			char a = eval.charAt(i);
			if (a == ' ' ) {
				continue;
			}
			if (Character.isDigit(a)) {
				push(Integer.parseInt(Character.toString(a)));
			}
			else if( (a=='+') || (a=='-') || (a=='*')  ) {
				if (stack.length < 2) {
					return -999;
				}
				int last = pop();
				int next = pop();
				if (a=='+') {
					push(last+next);
				}
				else if(a=='-') {
					push(next-last);
				}
				else if(a=='*') {
					push(next*last);
				}
			}
			else if(a=='~') {
				int last = pop();
				push(-1*last);		
			}
		}
		return pop();
	}

	public void push(int x) {

		int[] tmp = new int[stack.length+1];
		for (int i=0; i < stack.length; i++) {
			tmp[i] = stack[i];

		}
		tmp[stack.length] = x;
		stack = tmp;
	}

	public int pop() {
		int ret = stack[stack.length-1];
		if (stack.length == 1) {
			stack = new int[1];
		}
		else {
			int[] tmp = new int[stack.length-1];
			for (int i=0; i < stack.length-1; i++) {
				tmp[i] = stack[i];

			}
			stack = tmp;
		}
		return ret;
	}
}