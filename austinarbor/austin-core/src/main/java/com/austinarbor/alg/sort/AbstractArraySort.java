package com.austinarbor.alg.sort;


public abstract class AbstractArraySort<T extends Comparable<T>> implements ArraySort<T> {
	
	protected T[] data;
	
	public AbstractArraySort() { super(); }
	
	public AbstractArraySort(T[] data) {
		this.data = data;
	}
	
	public T[] getData() {
		return this.data;
	}
	
	public void setData(T[] data) {
		this.data = data;
	}
	
}
