package com.austinarbor.ds;


public class Heap<T extends Comparable<T>> {

	private T[] heap;
	private int size;
	
	@SuppressWarnings("unchecked")
	public Heap(final int capacity) {
		this.heap = (T[])new Comparable[capacity];
		this.size=0;
	}
	
	public void insert(final T item) {
		heap[size++] = item;
		trickleUp();
		if (size == heap.length) {
			resize();
		}
	}
	
	public void fastInsert(final T[] arr) {
		for(int i=0; i < arr.length; i++) {
			heap[i] = arr[i];
		}
		setSize(heap.length);
		for(int i=arr.length-1; i>0; i--) {
			trickleDown(i);
		}
	}
	
	private void setSize(final int size) {
		this.size = size;
	}
	
	public T removeMin() {
		T item = heap[0];
		heap[0] = heap[--size];
		trickleDown();
		return item;
	}
	
	private void trickleUp() {
		int index=size-1;
		while ((index >= 0) && (heap[index].compareTo(heap[((index-1)/2)]) < 0)) {
			swap(index, ((index-1)/2));
			index = ((index-1)/2);
		}
	}
	
	private void trickleDown() {
		trickleDown(0);
	}
	
	private void trickleDown(int start) {
		int index=start;
		while((index*2)+1 < size) {
			int childIndex = (index*2)+1;
			if ((childIndex+1 < size) && 
					heap[childIndex+1].compareTo(heap[childIndex]) < 0) {
				childIndex++;
			}
			if (heap[childIndex].compareTo(heap[index]) <0) {
				swap(childIndex, index);
				index = childIndex;
			}
			else {
				break;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void resize() {
		T[] tmp = (T[]) new Comparable[heap.length*2];
		System.arraycopy(heap, 0, tmp, 0, heap.length);
	}
	
	
	private void swap(final int firstIndex, final int secondIndex) {
		T tmp = heap[firstIndex];
		heap[firstIndex] = heap[secondIndex];
		heap[secondIndex] = tmp;
	}
	
}
