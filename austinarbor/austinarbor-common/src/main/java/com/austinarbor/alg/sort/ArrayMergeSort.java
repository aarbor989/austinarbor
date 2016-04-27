package com.austinarbor.alg.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayMergeSort<T extends Comparable<T>> extends AbstractArraySort<T> {
	
	private Class<T> clazz;
	
	public ArrayMergeSort() { super(); }
	
	public ArrayMergeSort(T[] data, Class<T> clazz) {
		super(data);
		this.clazz=clazz;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public T[] sort() {
		T[] work = (T[]) Array.newInstance(clazz, data.length);
		return mergeSort(work,0,data.length-1);
	}
	
	private T[] mergeSort(T[] work, int left, int right) {
		if(left == right) {
			return data;
		}
		int mid = (right+left)/2;
		mergeSort(work,left,mid);
		mergeSort(work,mid+1,right);
		
		merge(work,left,mid+1,right);
		
		return data;
	}
	
	public void merge(T[] work, int lowPtr, int highPtr, int upperBound) {
		int j=0;
		int lowerBound = lowPtr;
		int mid = highPtr-1;
		int n=upperBound-lowerBound+1;
		
		while(lowPtr <= mid && highPtr <= upperBound) {
			if(this.data[lowPtr].compareTo(this.data[highPtr]) < 0) {
				work[j++] = this.data[lowPtr++];
			} else {
				work[j++] = this.data[highPtr++];
			}
		}
		
		while(lowPtr <= mid) {
			work[j++] = this.data[lowPtr++];
		}
		while(highPtr <= upperBound) {
			work[j++] = this.data[highPtr++];
		}
		
		for(j=0; j<n;j++) {
			this.data[lowerBound+j] = work[j];
		}
	}

	public static void main(String[] args) {
		Integer[] a = {923,51,56,1,7,88,2,77};
		ArrayMergeSort<Integer> ams = new ArrayMergeSort<Integer>(a,Integer.class);
		ams.sort();
	}
	

}
