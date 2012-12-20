package spreadsheet;

import java.util.ArrayList;

/**
 * @version 2.0
 * Changed to use ArrayList
 */
public class Spreadsheet {
	
	private ArrayList<Node> list;
	private ArrayList<Position> positionList;
	private ArrayList<Position> cellList;


	private String name;
	public static int count;
	private int hash;

	
	/**
	 * Construct a spreadsheet of Nodes in an ArrayList
	 */
	public Spreadsheet() {
		list  = new ArrayList<Node>();
		name = "Sheet" + count;
		count++;
		hash = count;
		positionList = new ArrayList<Position>();
		cellList = new ArrayList<Position>();
	}
	
	/**
	 * Accesor method for getting name of spreadsheet
	 * @return String of name<count>
	 */
	public String getName() {
		return name;
	}
	 
	/**
	 * Checks for equality by name instead.
	 */
	public boolean equals(Spreadsheet other) {
		if (other == null)
			return false;
		return this.getName().equals(other.getName());
	}
	
	/**
	 * Uniq hashCode
	 * @return hashcode
	 */
	public int hashCode() {
		return hash;
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
	
	public  ArrayList<Position> getPosList() {
		return positionList;
	}
	public  ArrayList<Position> getCellList() {
		return cellList;
	}
	
	public boolean isCyclic() {
	int i = 0;
	if (this.getCellList().isEmpty() || this.getPosList().isEmpty())
		return false;
	while (i  < this.getCellList().size()) {
		for (Position pos : this.getPosList()) {
			if (this.getCellList().get(i).isEqualTo(pos))
				return true;
		}
		i++;
	}
	return false;
	}
	
	
}
