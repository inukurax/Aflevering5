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
	 * private method for checking for duplication
	 * @param position non null position
	 * @return -1 if not in list else index
	 */
	private int listContains(final Position position) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getKey().isEqualTo(position))
				return i;
		}
		return -1;
	}
		
	/**
	 * insert a Position and Expression (as a Node) in the Spreadsheet
	 * will overwrite if position already got an expression.
	 * @param position is a non null Position
	 * @param expression is a non null  Expression
	 */
	public void set(final Position position, final Expression expression) {
		int index = listContains(position);
		if (index != -1)
			list.set(index, new Node(position, expression));
		else
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
