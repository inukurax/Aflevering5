package spreadsheet;

public class Spreadsheet {
	
	private DynamicArrayMap list;
	
	/**
	 * Construct a spreadsheet from DynamicArrayMap
	 */
	public Spreadsheet() {
		list  = new DynamicArrayMap();
	}
		
	/**
	 * insert a Position and Expression (as a Node) in the Spreadsheet
	 * @param position is a non null Position
	 * @param expression is a non null  Expression
	 */
	public void set(final Position position, final Expression expression) {
		list.insert(position, expression); 
	}
	/**
	 * @param position is a non null Position
	 * @return associated Expression to the position
	 */
	public Expression get(final Position position) {
		return list.lookup(position);
	}
	
}
