/**
 * 
 */
package studying.ds;

/**
 * @author Austin
 *
 */
public abstract class AbstractList<T> implements List<T> {
	protected int size;
	
	protected AbstractList() {

	}

	public void insert(int position, T data) {
		throw new UnsupportedOperationException();
		
	}

	public void insert(T data) {
		insert(size(), data);
		
	}

	public boolean remove(T data) {
		throw new UnsupportedOperationException();
	}

	public T remove(int position) {
		throw new UnsupportedOperationException();
	}
	
	public boolean contains(T data) {
		throw new UnsupportedOperationException();
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int find(T data) {
		throw new UnsupportedOperationException();
	}

}
