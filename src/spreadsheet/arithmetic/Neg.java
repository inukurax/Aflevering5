package spreadsheet.arithmetic;

import spreadsheet.Expression;

public final class Neg extends Arithmetic {
	
	private int value;
	
	public Neg(final Expression operand) {
		value = operand.toInt() * - 1;
	}

	@Override
	public int evaluate() {
		return value;
	}
	
	

}
