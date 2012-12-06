package spreadsheet.arithmetic;

import spreadsheet.Expression;

public class Add extends Arithmetic {

	private int value;

	public Add(final Expression firstOperand, final Expression secondOperand) {
		value = firstOperand.toInt() + secondOperand.toInt();
	}

	@Override
	public int evaluate() {
		return value;
	}

}