/**
 * 
 */
package studying.ds.common;

/**
 * @author Austin
 *
 */
public class DNode<T> {
	private DNode<T> prev;
	private DNode<T> next;
	private T data;
	
	public DNode(T data) {
		this.data = data;
		prev = null;
		next = null;
	}
	
	/**
	 * @return the prev
	 */
	public DNode<T> getPrev() {
		return prev;
	}
	/**
	 * @param prev the prev to set
	 */
	public void setPrev(DNode<T> prev) {
		this.prev = prev;
	}
	/**
	 * @return the next
	 */
	public DNode<T> getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(DNode<T> next) {
		this.next = next;
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
}
