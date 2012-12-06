package spreadsheet.logical;

import spreadsheet.Expression;

public class Not extends Logical {
	
	private boolean value;
	
	public Not (final Expression operand) {
		value = !operand.toBoolean();
	}

	@Override
	public boolean evaluate() {
		return value;
	}

}
