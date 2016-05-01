package com.austinarbor.ds;


public class Stack<T> {
	private Node<T> top;
	private int size;

	public Stack() {
		top = null;
		size =0;
	}

	public void push(T data) {
		Node<T> node = new Node<T>(data);
		node.setNext(top);
		top = node;
		size++;
	}

	public T pop() {
		if(top == null) {
			return null;
		}
		else {
			T data = top.getData();
			top = top.getNext();
			size--;
			return data;
		}
	}

	public T peek() {
		return top.getData();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		Node<T> itr = top;
		while(itr != null) {
			buffer.append(itr.getData());
			if(itr.getNext() != null) {
				buffer.append(", ");
			}
			itr = itr.getNext();
		}
		buffer.append("]");

		return buffer.toString();
	}

}
