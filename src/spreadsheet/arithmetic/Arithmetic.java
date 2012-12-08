package spreadsheet.arithmetic;

import spreadsheet.Expression;
/**
 * Abstract class that extends Expression
 * used for handling the abstract methods from Expression
 *
 */
public abstract class Arithmetic extends Expression  {
	
	/**
	 * evaluate() is for using integer Expression
	 */
	public abstract int evaluate();

	@Override
	/** Converts to a boolean Expression
	 * @return false if integer is 0 else true
	 */
	public boolean toBoolean() {
		return this.evaluate() != 0;
	}
	@Override
	/** Converts to a Integer Expression
	 * @return integer of the Expression
	 */
	public int toInt() {
		return this.evaluate();
	}
	
	@Override	
	/** Converts to a String Expression
	 * @return the string representing the integer.
	 */
	public String toString() {
			return Integer.toString(this.evaluate());		
	}

}
