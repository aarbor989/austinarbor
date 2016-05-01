package com.austinarbor.ds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class ValueOrderedTreeMap<K,V extends Comparable<V>> implements SortedMap<K,V> {
	private SortedMap<Entry<K,V>,V> treeMap ;
	private Map<K,V> entryMap;
	private Comparator<Entry<K,V>> valueComparator;
	
	public ValueOrderedTreeMap() {
		
		valueComparator = new Comparator<Entry<K,V>>() {

			@Override
			public int compare(Entry<K, V> o1, Entry<K, V> o2) {
				return entryMap.get(o1.getKey()).compareTo(entryMap.get(o2.getKey()));
			}
			
		};
		treeMap = new TreeMap<Entry<K,V>,V>(valueComparator);
		entryMap = new HashMap<K,V>();
	}
	
	
	public V put(K key, V value) {
		Entry<K,V> entry = new Entry<K,V>(key,value);
		if(entryMap.containsKey(key)) {
			Entry<K,V> origEntry = new Entry<K,V>(key,entryMap.get(key));
			treeMap.remove(origEntry);
		}
		entryMap.put(key,value);
		treeMap.put(entry, value);
		return value;
	}
	
	public Set<K> keySet() {
		return entryMap.keySet();
	}
	
	public Set<Entry<K,V>> valueSortedKeySet() {
		return treeMap.keySet();
	}
	
	/**
     * Returns a {@link Collection} view of the values contained in this map.
     * The collection is backed by the map, so changes to the map are
     * reflected in the collection, and vice-versa.  If the map is
     * modified while an iteration over the collection is in progress
     * (except through the iterator's own <tt>remove</tt> operation),
     * the results of the iteration are undefined.  The collection
     * supports element removal, which removes the corresponding
     * mapping from the map, via the <tt>Iterator.remove</tt>,
     * <tt>Collection.remove</tt>, <tt>removeAll</tt>,
     * <tt>retainAll</tt> and <tt>clear</tt> operations.  It does not
     * support the <tt>add</tt> or <tt>addAll</tt> operations.
     */
	public Collection<V> values() {
		return treeMap.values();
	}
	
	 /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * <p>More formally, if this map contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code key} compares
     * equal to {@code k} according to the map's ordering, then this
     * method returns {@code v}; otherwise it returns {@code null}.
     * (There can be at most one such mapping.)
     *
     * <p>A return value of {@code null} does not <i>necessarily</i>
     * indicate that the map contains no mapping for the key; it's also
     * possible that the map explicitly maps the key to {@code null}.
     * The {@link #containsKey containsKey} operation may be used to
     * distinguish these two cases.
     *
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *         and this map uses natural ordering, or its comparator
     *         does not permit null keys
     */
	@Override
	public V get(Object key) {
		return entryMap.get(key);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public V remove(Object key) {
		if(entryMap.containsKey(key)) {
			Entry<K,V> treeEntry = new Entry<K,V>((K)key,entryMap.get(key));
			treeMap.remove(treeEntry);
		}
		return entryMap.remove(key);
	}
	
	
	public SortedMap<K,V> subMap(V fromValue, V toValue) {
		if(treeMap.isEmpty()) {
			return null;
		}
		
		if(treeMap.firstKey().getValue().compareTo(fromValue) < 0) {
			return null;
		}
		
		Set<Entry<K,V>> entries = treeMap.keySet();
		Iterator<Entry<K,V>> iter = entries.iterator();
		Entry<K,V> entry = iter.next();
		ValueOrderedTreeMap<K,V> tMap = new ValueOrderedTreeMap<K,V>();
		while(iter.hasNext() && entry.getValue().compareTo(toValue) <=0) {
			tMap.put(entry.getKey(), entry.getValue());
		}
		
		return tMap;
	}
	
	@Override
	public int size() {
		return entryMap.size();
	}


	@Override
	public boolean isEmpty() {
		return size() ==0;
	}


	@Override
	public boolean containsKey(Object key) {
		return entryMap.containsKey(key);
	}


	@Override
	public boolean containsValue(Object value) {
		return entryMap.containsValue(value);
	}


	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		Iterator<? extends Map.Entry<? extends K, ? extends V>> iter = m.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<? extends K, ? extends V> entry = iter.next();
			put(entry.getKey(),entry.getValue());
		}
	}


	@Override
	public void clear() {
		entryMap.clear();
		treeMap.clear();		
	}


	@Override
	public Comparator<? super K> comparator() {
		throw new UnsupportedOperationException("This method is not applicable for Value Sorted TreeMap");
	}


	@Override
	public SortedMap<K, V> subMap(K fromKey, K toKey) {
		throw new UnsupportedOperationException("Not yet implemented");
	}


	@Override
	public SortedMap<K, V> headMap(K toKey) {
		throw new UnsupportedOperationException("Not yet implemented");
	}


	@Override
	public SortedMap<K, V> tailMap(K fromKey) {
		throw new UnsupportedOperationException("Not yet implemented");
	}


	@Override
	public K firstKey() {
		return treeMap.firstKey().getKey();
	}


	@Override
	public K lastKey() {
		return treeMap.lastKey().getKey();
	}


	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return entryMap.entrySet();
	}
	
	public static void main(String[] args) {
		ValueOrderedTreeMap<String,Integer> map = new ValueOrderedTreeMap<String,Integer>();
		map.put("Hello", 1);
		map.put("World", 0);
		map.put("My", -1);
		map.put("Test1", 8);
		map.put("Test2", 7);
		
		/*Set<Entry<String,Integer>> keySet = map.valueSortedKeySet();
		for(Entry<String,Integer> valueEntry : keySet) {
			System.out.println(valueEntry.getValue());
		}*/
		
		List<Integer> values = new ArrayList<Integer>(map.values());
		for(int i : values) {
			System.out.println(i);
		}
	}
	
	private static class Entry<K,V extends Comparable<V>> implements Map.Entry<K, V> {
	private K key;
	private V value;
	
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * @return the key
	 */
	public K getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(K key) {
		this.key = key;
	}
	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public V setValue(V value) {
		V origValue = this.value;
		this.value = value;
		
		return origValue;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Entry))
			return false;
		Entry<K,V> other = (Entry<K,V>) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
}
	
}
