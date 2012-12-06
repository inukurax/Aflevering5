package spreadsheet.logical;

import spreadsheet.Expression;

public class Conjunct extends Logical {
	
	private boolean value;
	/**
	 * 
	 * @param firstOperand non null Expression
	 * @param secondOperand non null Expression
	 */
	public Conjunct(final Expression firstOperand,
					final Expression secondOperand) {
		
		value = firstOperand.toBoolean() && secondOperand.toBoolean();
	}

	@Override
	public boolean evaluate() {
		return value;
	}

}
