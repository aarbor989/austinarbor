/**
 * 
 */
package com.austinarbor.ds;

/**
 * Simple stack implementation using an array.
 * @author Austin G. Arbor
 */
public class StackArray<T> {

	private int size;
	private Object[] stack;
	private int top;
	
	public StackArray(final int size) {
		this.size = size;
		stack = new Object[size];
		this.top = -1;
	}
	
	public void push(long j) {
		stack[++top] = j;
	}
	
	@SuppressWarnings("unchecked")
	public T pop() {
		return (T)stack[top--];
	}
	
	@SuppressWarnings("unchecked")
	public T peek() {
		return (T)stack[top];
	}
	
	public boolean isFull() {
		return top == size;
	}

}
