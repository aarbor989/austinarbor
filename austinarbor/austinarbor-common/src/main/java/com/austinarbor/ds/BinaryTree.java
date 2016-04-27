package com.austinarbor.ds;

public class BinaryTree<T extends Comparable<T>> {
	private TreeNode<T> root;
	private boolean useRecursion;
	private int size;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(TreeNode<T> root) {
		this(root, true);
	}

	public BinaryTree(TreeNode<T> root, boolean useRecursion) {
		this.root = root;
		this.useRecursion = useRecursion;
		this.size = getNumElements();
	}

	/**
	 * @return the root
	 */
	public TreeNode<T> getRoot() {
		return root;
	}


	public int getMaxDepth() {
		if(root == null ){
			return 0;
		}

		int leftDepth = 1+ getMaxDepth(root.getLeft());
		int rightDepth = 1+getMaxDepth(root.getRight());
		return leftDepth >= rightDepth ? leftDepth : rightDepth ;
	}

	private int getMaxDepth(TreeNode<T> branch) {
		if (branch == null){
			return 0;
		} 
		
		int leftDepth = 1 + getMaxDepth(branch.getLeft());
		int rightDepth = 1 + getMaxDepth(branch.getRight());
		return leftDepth >= rightDepth ?  leftDepth :  rightDepth;
	}

	public int getNumElements() {
		if (root == null) {
			return 0;
		} else {
			return 1 + getNumElements(root.getLeft()) + getNumElements(root.getRight());
		}
	}

	private int getNumElements(TreeNode<T> branch) {
		if (branch == null ) {
			return 0;
		} else {
			return 1 + getNumElements(branch.getLeft()) + getNumElements(branch.getRight());
		}
	}

	public void insert(TreeNode<T> node) {
		insert(node, root);
		size++;
	}

	private TreeNode<T> insert(TreeNode<T> insert, TreeNode<T> branch) {
		if(branch == null) {
			branch = insert;
		} else if (insert.getData().compareTo(branch.getData()) <=0) {
			branch.setLeft(insert(insert, branch.getLeft()));
		} else {
			branch.setRight(insert(insert,branch.getRight()));
		}
		return branch;
	}

	public void insert(T data) {
		if(isUseRecursion()) {
			insert(data, root);
		} else {
			insertNoRec(data);
		}
		size++;

	}

	private TreeNode<T> insert(T data, TreeNode<T> branch) {
		if (branch == null) {
			branch = new TreeNode<T>(data);
		}
		else if (data.compareTo(branch.getData()) <=0) {
			branch.setLeft(insert(data, branch.getLeft()));
		}
		else {
			branch.setRight(insert(data, branch.getRight()));
		}
		return branch;
	}

	public void insertNoRec(T data) {
		TreeNode<T> node = new TreeNode<T>(data);
		if(root == null){
			root = node;
		} else {
			TreeNode<T> current = root;
			TreeNode<T> parent;
			while(true) {
				parent = current;
				if(data.compareTo(current.getData()) <=0) {
					current = current.getLeft();
					if(current == null) {
						parent.setLeft(node);
						return;
					}
				} else {
					current = current.getRight();
					if(current == null) {
						parent.setRight(node);
						return;
					}
				}
			}
		}
	}

	public TreeNode<T> delete(T data) {
		if(root == null) {
			return root;
		} else {
			TreeNode<T> current = root;
			TreeNode<T> parent=null;
			boolean isLeftChild = true;
			while(current!= null && !current.getData().equals(data)) {
				parent = current;
				if(data.compareTo(current.getData()) < 0) {
					current = current.getLeft();
					isLeftChild=true;
				} else {
					current = current.getRight();
					isLeftChild=false;
				}
			}
			//node isn't here
			if(current == null) {
				return null;
			} else {
				TreeNode<T> ret = current;

				if(current.getLeft() == null && current.getRight() == null) {
					if(current == root) {
						root = null;
						return root;
					} else if(isLeftChild) {
						parent.setLeft(null);
					} else {
						parent.setRight(null);
					}
				} else if(current.getLeft() == null) {
					if(current == root) {
						root = current.getRight();
					} else if(isLeftChild) {
						parent.setLeft(current.getRight());
					} else {
						parent.setRight(current.getRight());
					}
				} else if (current.getRight() == null) {
					if(current == root) {
						root = current.getLeft();
					} else if(isLeftChild) {
						parent.setLeft(current.getLeft());
					} else {
						parent.setRight(current.getLeft());
					}
				} else {
					TreeNode<T> successor = getSuccessor(current);
					if(current == root) {
						root = successor;
					}else if(isLeftChild) {
						parent.setLeft(successor);
					} else {
						parent.setRight(successor);
					}
					successor.setLeft(current.getLeft());
				}
				size--;
				return ret;
			}
		}
	}

	private TreeNode<T> getSuccessor(TreeNode<T> node) {
		TreeNode<T> parent = node;
		TreeNode<T> successor = node;
		TreeNode<T> current = node.getRight();
		while(current != null) {
			parent = successor;
			successor = current;
			current = current.getLeft();
		}
		if(successor != node.getRight()) {
			parent.setLeft(successor.getRight());
			successor.setRight(node.getRight());
		}
		return successor;
	}

	public void printInOrder() {
		printInOrder(root);
	}

	private void printInOrder(TreeNode<T> branch) {
		if(branch != null) {
			printInOrder(branch.getLeft());
			System.out.println(branch.getData());
			printInOrder(branch.getRight());
		} else {
			return;
		}
	}

	/**
	 * @return the useRecursion
	 */
	public boolean isUseRecursion() {
		return useRecursion;
	}

	/**
	 * @param useRecursion the useRecursion to set
	 */
	public void setUseRecursion(boolean useRecursion) {
		this.useRecursion = useRecursion;
	}
}
