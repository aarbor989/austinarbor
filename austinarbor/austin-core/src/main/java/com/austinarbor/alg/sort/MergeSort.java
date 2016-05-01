package com.austinarbor.alg.sort;

import java.util.ArrayList;

import java.util.List;

public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {

	
	public MergeSort() { super(); }
	
	public MergeSort(List<T> data) {
		super(data);
	}
	

	@Override
	public List<T> sort() {
		List<T> work =  this.data;
		this.data = mergeSort(work);
		
		return this.data;
	}
	
	private List<T> mergeSort(List<T> work) {
		List<T> left = new ArrayList<T>();
		List<T> right = new ArrayList<T>();
		int mid;
		if(work.size() == 1) {
			return work;
		}
		
		mid = work.size()/2;
		for(int i=0; i < mid; i++) {
			left.add(work.get(i));
		}
		for(int i=mid; i < work.size(); i++) {
			right.add(work.get(i));
		}
		left = mergeSort(left);
		right = mergeSort(right);
		
		merge(left,right,work);
		
		return work;
	}
	
	private void merge(List<T> left, List<T> right, List<T> work) {
		int leftIndex=0;
		int rightIndex=0;
		int workIndex=0;
		
		while(leftIndex < left.size() && rightIndex < right.size()) {
			if((left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
				work.set(workIndex++, left.get(leftIndex++));
			} else {
				work.set(workIndex++, right.get(rightIndex++));
			}
		}
		
		for(int i = leftIndex; i < left.size(); i++) {
			work.set(workIndex++, left.get(i));
		}
		
		for(int i=rightIndex; i < right.size(); i++) {
			work.set(workIndex++, right.get(i));
		}
		
		/*List<T> rest;
		int restIndex;
		if(leftIndex >= left.size()) {
			rest = right;
			restIndex = rightIndex;
		} else {
			rest = left;
			restIndex = leftIndex;
		}
		
		for(int i=restIndex; i < rest.size(); i++) {
			work.set(workIndex++,rest.get(i));
		}
		*/
	}
	

}
