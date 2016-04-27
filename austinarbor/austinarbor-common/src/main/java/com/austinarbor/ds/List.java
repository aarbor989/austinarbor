/**
 * 
 */
package com.austinarbor.ds;

/**
 * @author Austin
 *
 */
public interface List<T> {
	
	/**
	 * Inserts an element in the specified position
	 * @param position
	 * @param data
	 */
	void insert(int position, T data);
	
	void insert(T data);
	
	/**
	 * Removes the first occurrence of the element from the list
	 * @param data
	 * @return
	 */
	boolean remove(T data);
	
	/**
	 * Removes the element from the specified position
	 * @param position
	 * @return The removed element
	 */
	T remove(int position);
	
	/**
	 * The number of elements in the <tt>List</tt>
	 * @return
	 */
	int size();
	
	/**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
	boolean isEmpty();
	
	boolean contains(T data);
	
	int find(T data);
}
