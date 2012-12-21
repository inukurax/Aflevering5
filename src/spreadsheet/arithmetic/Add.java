package spreadsheet.arithmetic;

import spreadsheet.Expression;

public final class Add extends Arithmetic {

	private int value;

	/**
	 * 
	 * @param firstOperand non null
	 * @param secondOperand non null
	 */
	public Add(final Expression firstOperand, final Expression secondOperand) {
		value = firstOperand.toInt() + secondOperand.toInt();
	}

	@Override
	public int evaluate() {
		return value;
	}

}