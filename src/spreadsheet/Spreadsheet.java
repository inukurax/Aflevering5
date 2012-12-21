package spreadsheet;

import java.util.ArrayList;

/**
 * @version 3.0
 * Changed to use ArrayList
 * Added name and positionList and cellList.
 */
public class Spreadsheet {
	
	// Holds nodes added to Spreadsheet.
	private ArrayList<Node> list;

	private String name;
	public static int count;
	private int hash;
	private Cyclic cyclicList;

	
	/**
	 * Construct a spreadsheet of Nodes in an ArrayList
	 * Spreadsheet is giving name Sheet<Count>
	 * Initializes positionList and cellList.
	 * Sets hashCode to Count++, for uniqueness.
	 */
	public Spreadsheet() {
		list  = new ArrayList<Node>();
		name = "Sheet" + count;
		count++;
		hash = count;
		cyclicList = new Cyclic();
	}
	
	/**
	 * Accesor method for getting name of spreadsheet
	 * @return String of name<count>
	 */
	public String getName() {
		return name;
	}
	 
	/**
	 * Overrides equals method to
	 * check for equality by Spreadsheet name.
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		return this.getName().equals(((Spreadsheet) other).getName());
	}
	
	/**
	 * Unique hashCode
	 * @return hashCode for the Spreadsheet.
	 */
	public int hashCode() {
		return hash;
	}
	
	
	/**
	 * Gets the Cyclic object.
	 * @return Cyclic for this Spreadsheet
	 */
	public Cyclic getCyclic() {
		return this.cyclicList;
	}
	
	/**
	 * Private method for checking for duplication of Positions in Spreadsheet
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
	 * Inserts a Position and Expression (as a Node) in the Spreadsheet
	 * will overwrite if position already got an expression.
	 * @param position is a non null Position
	 * @param expression is a non null  Expression
	 */
	public void set(final Position position, final Expression expression) {
		int index = listContains(position);
		if (index != -1) {
			list.set(index, new Node(position, expression));
		}
		else {
			list.add(new Node (position, expression)); 
		}
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
