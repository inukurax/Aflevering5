package spreadsheet.textual;

import spreadsheet.Expression;

public class Concat extends Textual {
	
	private String value;
	
	public Concat (final Expression firstOperand, final Expression secondOperand) {
		value = firstOperand.toString() + secondOperand.toString();
	}

	@Override
	public String evaluate() {
		return value;
	}
	

}
