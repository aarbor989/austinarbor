package com.austinarbor.alg.sort;


public interface ArraySort<T extends Comparable<T>> {
	
	public T[] sort();
	
	public T[] getData();
	
	public void setData(T[] data);
}
