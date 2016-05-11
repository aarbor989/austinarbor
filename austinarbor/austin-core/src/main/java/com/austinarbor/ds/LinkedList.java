/**
 * 
 */
package com.austinarbor.ds;

import com.austinarbor.ds.Node;

/**
 * @author Austin G. Arbor
 *
 */
public class LinkedList<T> extends AbstractList<T> {
	private Node<T> head;
	
	public LinkedList() {
		super();
	}
		
	public void insertFirst(T data) {
		if(head == null) {
			head = new Node<T>(data);
		} else {
			Node<T> newHead = new Node<T>(data);
			newHead.setNext(head);
			head = newHead;
		}
		size++;
	}
	
	public void insertLast(T data) {
		if(head == null) {
			head = new Node<T>(data);
		} else {
			Node<T> node = head;
			while (node.getNext() != null) {
				node = node.getNext();
			}
			node.setNext(new Node<T>(data));
		}
		size++;
	}
	
	public void insert(int position, T data) {
		if(position <= 0) {
			insertFirst(data);
		} else if (position >= size()) {
			insertLast(data);
		} else {
			if(head == null) {
				head = new Node<T>(data);
			} else {
				Node<T> node = head;
				for(int i=0; i <position-1; i++) {
					node = node.getNext();
				}
				Node<T> newNode = new Node<T>(data);
				newNode.setNext(node.getNext());
				node.setNext(newNode);
			}
			size++;
		}
	}
	
	public T removeFirst() {
		Node<T> node = head;
		if(head != null) {
			head = head.getNext();
		}
		size--;
		return node.getData();
	}
	
	public T removeLast() {
		if(head == null) {
			return null;
		}
		Node<T> node = head;
		Node<T> parent= null;
		while(node.getNext() != null) {
			parent = node;
			node = node.getNext();
		}
		T data = node.getData();
		parent.setNext(null);
		size--;
		return data;
	}
	
	public T remove(int position) {
		if(position <=0) {
			return removeFirst();
		} else if(position >= size()) {
			return removeLast();
		} else {
			Node<T> node = head;
			for(int i=0; i < position-1; i++) {
				node = node.getNext();
			}
			T data = node.getNext().getData();
			node.setNext(node.getNext().getNext());
			
			return data;
		}
	}
	
	public int find(T data) {
		if(head == null) {
			return -1;
		}
		int position =0;
		Node<T> node = head;
		while(node != null ) {
			if(node.getData().equals(data)) {
				return position;
			}
			node = node.getNext();
			position++;
		}
		return -1;
	}
	
	@Override
	public boolean contains(T data) {
		return (find(data) != -1);
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.insert(1);
		ll.insertLast(6);
		ll.insertLast(8);
		ll.insertFirst(2);
		ll.insert(3,10);
		ll.insert(10,15);
		ll.remove(10);
		for(Node<Integer> node = ll.getHead(); node!= null; node = node.getNext()) {
			System.out.println(node.getData());
		}
		System.out.println(ll.find(10));
	}
	
	
	public Node<T> getHead() {
		return this.head;
	}
	
	public void setHead(Node<T> head) {
		this.head = head;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		Node<T> node = head;
		while(node != null) {
			buffer.append(node.getData());
			if(node.getNext() != null) {
				buffer.append(", ");
			}
			node = node.getNext();
		}
		buffer.append("]");
		return buffer.toString();
	}
	
}
