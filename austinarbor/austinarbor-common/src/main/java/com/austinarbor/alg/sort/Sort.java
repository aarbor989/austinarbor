package com.austinarbor.alg.sort;

import java.util.List;

public interface Sort<T extends Comparable<T>> {
	public List<T> sort();
	
	public List<T> getData();
	
	public void setData(List<T> data);
	
}
