package spreadsheet;

/**
 * 
 * CellReference extends Expression
 */
public final class CellReference extends Expression {
	
	private Spreadsheet sheet;
	private Position pos;
	
	/**
	 * Stores a reference in a Spreadsheet with a non null Position
	 * @param spread a Spreadsheet
	 * @param position a non null Position
	 */
	public CellReference (final Spreadsheet spread, final Position position) {
		this.sheet = spread;
		this.pos = position;

	}

	@Override
	/**
	 * @return the boolean Expression which the CellReference refers to.
	 */
	public boolean toBoolean() {
		  return sheet.get(pos).toBoolean();
	}
	@Override
	/**
	 * @return the Integer Expression which the CellReference refers to.
	 */
	public int toInt() {
			return sheet.get(pos).toInt();
	}
	@Override
	/**
	 * @return the String Expression which the CellReference refers to.
	 */
	public String toString() {
			return sheet.get(pos).toString();
	}
	

}
