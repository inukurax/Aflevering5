package spreadsheet.logical;

import spreadsheet.Expression;

public final class Disjunct extends Logical{
	
	private boolean value;
	
	public Disjunct (final Expression firstOperand, 
					 final Expression secondOperand) {
		
		value = firstOperand.toBoolean() || secondOperand.toBoolean();
	}

	@Override
	public boolean evaluate() {
		return value;
	}

}
