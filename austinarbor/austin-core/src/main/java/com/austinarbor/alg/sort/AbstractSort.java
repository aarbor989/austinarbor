package com.austinarbor.alg.sort;

import java.util.List;

public abstract class AbstractSort<T extends Comparable<T>> implements Sort<T> {
	
	protected List<T> data;
	
	public AbstractSort() { super(); }
	
	public AbstractSort(List<T> data) {
		this.data = data;
	}
	
	public List<T> getData() {
		return  this.data;
	}
	
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
