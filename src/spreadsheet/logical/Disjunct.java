package spreadsheet.logical;

import spreadsheet.Expression;

public class Disjunct extends Logical{
	
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
