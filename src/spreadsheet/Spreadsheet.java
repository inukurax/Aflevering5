package spreadsheet;

import java.util.ArrayList;

/**
 * @version 2.0
 * Changed to use ArrayList
 */
public class Spreadsheet {
	

	private ArrayList<Node> list;
	
	/**
	 * Construct a spreadsheet of Nodes in an ArrayList
	 */
	public Spreadsheet() {
		list  = new ArrayList<Node>();
	}
		
	/**
	 * insert a Position and Expression (as a Node) in the Spreadsheet
	 * @param position is a non null Position
	 * @param expression is a non null  Expression
	 */
	public void set(final Position position, final Expression expression) {
		list.add(new Node (position, expression)); 
	}
	/**
	 * @param position is a non null Position
	 * @return associated Expression to the position
	 */
	public Expression get(final Position position) {
		for (Node node : list) {
			if (node.getKey().isEqualTo(position)) 
				return node.getValue();
		}
		return null;
	}
	
}
