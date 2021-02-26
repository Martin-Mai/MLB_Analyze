package pc_app;
import java.util.ArrayList;

/**
 * @file HashMapLP.java
 * @author 2XB3 L01 Group 8
 * @date April 12, 2020
 */

/**
 * @brief An implementation of Linear Probing Hash ST from the textbook
 *
 * @param <Key> The type of the keys
 * @param <Value> The type of the values
 */
public class HashMapLP<Key, Value> {
	private static int n;
	private int m;
	private Key[] keys;
	private Value[] vals;
	
	/**
	 * @brief Default constructor for the class
	 */
	public HashMapLP() {
		this(16);
	}
	
	/**
	 * @brief Constructor for the class
	 * @param m The initial size of the keys and vals arrays
	 */
	public HashMapLP(int m) {
		this.m = m;
		this.keys = (Key[]) new Object[m];
		this.vals = (Value[]) new Object[m];
	}
	
	/**
	 * @brief Puts a key value pair into the hashmap
	 * @param key The key
	 * @param val The value
	 */
	public void put(Key key, Value val) {
		if (this.n >= this.m/2) {
			resize(2*this.m);
		}
		
		int i;
		for(i = hash(key); this.keys[i] != null; i = (i + 1) % m)
			if (this.keys[i].equals(key)){ this.vals[i] = val; return; }
		this.keys[i] = key;
		this.vals[i] = val;
		this.n++;
	}
	
	/**
	 * @brief Gets the value of a given key (if it exists in the hashmap)
	 * @param key The key
	 * @return The value
	 */
	public Value get(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
			if (this.keys[i].equals(key)) return this.vals[i];
		return null;
	}
	
	/**
	 * @brief Returns how many entries there are in the hashmap
	 * @return The amount of entries in the hashmap
	 */
	public static int size() {
		return n;
	}
	
	/**
	 * @brief Returns a set of all the keys
	 * @return The set of keys
	 */
	public ArrayList<Key> keyset(){
		ArrayList<Key> keyset = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			if (this.keys[i] != null) keyset.add(keys[i]);
		}
		return keyset;
	}
	
	// Resizes the array when the amount of entries (n) is greater than half the size of m
	private void resize(int cap) {
		HashMapLP t = new HashMapLP(cap);
		for(int i = 0; i < this.m; i++) {
			if (this.keys[i] != null) t.put(this.keys[i], this.vals[i]);
		}
		this.keys = (Key[]) t.keys;
		this.vals = (Value[]) t.vals;
		this.m = t.m;
	}
	
	// Gets the hash code of the key
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % this.m;
	}
}
