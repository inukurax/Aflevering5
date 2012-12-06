package spreadsheet;

import java.util.Arrays;

public class DynamicArrayMap {
	
	// array stores the Nodes in an Array
	// index keeps count of the index number of the array
	private Node[] array;
	private int index;
	
	/**
	 * Constructs a DynamicArrayMap
	 * with a starting length of 1
	 * and index 0
	 */
	public DynamicArrayMap() {
		this.array = new Node[1];
		this.array[0] = null;
		this.index = 0;
	}
	
	/**
	 * Inserts a Node of a Position and Expression
	 * and increments index and array.length to match
	 * @param key a non null Position
	 * @param value a non null Expression
	 */
	public void insert(final Position key, final Expression value) {
		if (index == array.length) {
			array = Arrays.copyOf(array, array.length * 2);
			array[index] = new Node(key, value);
		}
		else 
			array[index] = new Node(key, value);
		
		index++;
	}
	/**
	 * @param key a non null Position
	 * @return the Expression associated with the key
	 */
	public Expression lookup(final Position key) {
		for (int i = 0; i < index; i++) {
			  if (array[i].getKey().isEqualTo(key)) {
				  return array[i].getValue();
			  }
		}
		return null;
	}
	
}
