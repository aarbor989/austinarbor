package com.austinarbor.ds;

import com.austinarbor.ds.DNode;

public class DoubleLinkedList<T> extends AbstractList<T> {
	
	private DNode<T> head;
	private DNode<T> tail;
	
	public DoubleLinkedList() {
		super();
	}
	
	@Override
	public void insert(int position, T data) {
		if(position <=0 || head == null) {
			insertFirst(data);
		} else if (position >= size()) {
			insertLast(data);
		} else {
			DNode<T> node = head;
			DNode<T> newNode = new DNode<T>(data);
			for(int i=0; i < position-1;i++) {
				node = node.getNext();
			}
			newNode.setNext(node.getNext());
			newNode.setPrev(node);
			node.setNext(newNode);
			newNode.getNext().setPrev(newNode);
			size++;
		}
		
	}
	
	public void insertLast(T data) {
		if(tail == null) {
			insertFirst(data);
		} else {
			DNode<T> newNode = new DNode<T>(data);
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
			if(tail.getPrev() == null) {
				head = tail;
			}
		}
		size++;
	}
	
	public void insertFirst(T data) {
		DNode<T> newNode = new DNode<T>(data);
		newNode.setNext(head);
		head = newNode;
		if(head.getNext() == null) {
			tail = head;
		}
		size++;
	}
	
	public boolean remove(T data) {
		DNode<T> node = head;
		while(node != null && !node.getData().equals(data)) {
			node = node.getNext();
		}
		if(node == null) {
			return false;
		}
		
		node.getPrev().setNext(node.getNext());
		if(node.getNext() != null) {
			node.getNext().setPrev(node.getPrev());
		} else {
			tail = node;
		}
		size--;
		return true;
	}
	
	public T removeFirst() {
		if(head == null) {
			return null;
		}
		T data = head.getData();
		head = head.getNext();
		size--;
		return data;
	}
	
	public T removeLast() {
		if(tail == null) {
			return null;
		}
		T data = tail.getData();
		tail = tail.getPrev();
		size--;
		return data;
	}
	
	@Override
	public boolean contains(T data) {
		return (find(data) != -1);
	}
	
	@Override
	public int find(T data) {
		int position=0;
		DNode<T> node = head;
		while(node != null) {
			if(node.getData().equals(data)) {
				return position;
			}
			position++;
			node = node.getNext();
		}
		return -1;
	}
	
	/**
	 * @return the head
	 */
	public DNode<T> getHead() {
		return head;
	}
	/**
	 * @param head the head to set
	 */
	public void setHead(DNode<T> head) {
		this.head = head;
	}

	/**
	 * @return the tail
	 */
	public DNode<T> getTail() {
		return tail;
	}

	/**
	 * @param tail the tail to set
	 */
	public void setTail(DNode<T> tail) {
		this.tail = tail;
	}

}
