/**
 * 
 */
package com.austinarbor.ds;


/**
 * A Node object for use in singly linked implementations.
 * @author Austin G. Arbor
 */
public class Node<T> {
	private T data;
	private Node<T> next;
	
	public Node() { }
	
	/**
	 * Constructor with preknown data element.
	 * @param data
	 */
	public Node(T data) {
		this(data,null);
	}
	
	/**
	 * Constructor with preknown data element and
	 * next Node
	 * @param data
	 * @param next
	 */
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
