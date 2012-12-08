package spreadsheet.textual;

import spreadsheet.Expression;

public abstract class Textual extends Expression  {
	
	/**
	 * is an abstract method for storing
	 * the String Expression
	 */
	public abstract String evaluate();

	@Override
	/** Converts to boolean Expression
	 * @return boolean Expression
	 */
	public boolean toBoolean() {
		return !this.evaluate().isEmpty();
	}
	
	@Override
	/** Converts to integer Expression
	 * @return integer Expression
	 */
	public int toInt() {
		return this.evaluate().length();
	}
	
	@Override	
	/** Converts to String Expression
	 * @return String Expression
	 */
	public String toString() {
		return this.evaluate();
	}

}
