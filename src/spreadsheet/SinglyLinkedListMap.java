package spreadsheet;

/**
 * @deprecated
 * Spreadsheet uses ArrayList instead
 *
 */
@Deprecated
public class SinglyLinkedListMap {
	
	private LinkedList current;
	private LinkedList subsequent;
	
	/**
	 * The class LinkedList is for making a list
	 */
	private class LinkedList {
		
		// node is the Node
		private Node node;
		// rest is the list of Nodes
		private LinkedList rest;
		
		/**
		 * Constructs an object of LinkedList
		 * Used for storing Nodes in a list.
		 * @param pos Position of Node
		 * @param exp Expression of Node
		 */	
		public LinkedList(final Position pos, final Expression exp) {
			this.node = new Node(pos, exp);
			this.rest = null;
		}
	}
	
	/**
	 * Constructs an empty list
	 */
	public SinglyLinkedListMap() {
		this.current = null;
		this.subsequent = null;
	}

	
	/**
	 * inserts a Position and Expression in a SinglyLinkedList
	 * @param key a not null Position
	 * @param value a not null Expression
	 */
	public void insert(final Position key, final Expression value) {
		// only needs to make object once
		LinkedList linkedList = new LinkedList(key, value);
		if (current == null) {
			this.current = linkedList;
			this.subsequent = linkedList;

		}
		else {
			this.subsequent.rest = linkedList;
			this.subsequent = linkedList;
		}
	}
	/**
	 * Looks for a Position in the SinglyLinkedListMap
	 * @param key is a non null Position 
	 * @return the Expression associated with the
	 * 		   key: if none found returns null
	 */
	public Expression lookup(final Position key) {
		if (this.current == null)
				return null;
		
		LinkedList temp = this.current;
        while (temp != this.subsequent){
        	
        	if (temp.node.getKey().isEqualTo(key))
        		return temp.node.getValue();
        	else
        		temp = temp.rest;
        }
        if (this.subsequent.node.getKey().isEqualTo(key))
        	return temp.node.getValue();
        else
        	return null;		
	}
	

}
