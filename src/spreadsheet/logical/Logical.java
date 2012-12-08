package spreadsheet.logical;

import spreadsheet.Expression;

public abstract class Logical extends Expression {
	
	/**
	 * evaluate stores the boolean Expression
	 * 
	 */
	public abstract boolean evaluate();

	@Override	
	/** Converts to a boolean Expression
	 * @return boolean.
	 */
	public boolean toBoolean() {
		return this.evaluate();
	}
	
	@Override	
	/** Converts to a integer Expression
	 * @return integer.
	 */
	public int toInt() {
		if (this.evaluate())
			return 1;
		else
			return 0;
	}
	
	@Override	
	/** Converts to a String Expression
	 * @return String.
	 */
	public String toString() {
		if (this.evaluate()) 
			return "true";
		else 
			return "";	
	
	}
}
