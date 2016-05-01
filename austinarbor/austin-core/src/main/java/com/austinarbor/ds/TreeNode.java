package com.austinarbor.ds;

/**
 * 
 * @author Austin G. Arbor
 *
 */
public class TreeNode<T> {
	
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;
	private boolean marked = false;
	
	/**
	 * Default constructor.
	 */
	public TreeNode() { }
	
	/**
	 * Constructor for use when only the data 
	 * is known
	 * @param data
	 */
	public TreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Constructor for use when the data and both the left-child
	 * and right-child nodes are known.
	 * @param data
	 * @param left
	 * @param right
	 */
	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Convenience method provided to automatically create new
	 * left and right child nodes based on a data element only.
	 * @param data
	 * @param leftValue
	 * @param rightValue
	 */
	public TreeNode(T data, T leftValue, T rightValue) {
		this.data = data;
		this.setLeft(new TreeNode<T>(leftValue));
		this.setRight(new TreeNode<T>(rightValue));
	}
	
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * @return the left
	 */
	public TreeNode<T> getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public TreeNode<T> getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	/**
	 * @return the marked
	 */
	public boolean isMarked() {
		return marked;
	}

	/**
	 * @param marked the marked to set
	 */
	public void setMarked(boolean marked) {
		this.marked = marked;
	}

}
