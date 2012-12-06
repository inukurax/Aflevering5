package spreadsheet.textual;

import spreadsheet.Expression;

public abstract class Textual extends Expression  {
	
	public abstract String evaluate();

	@Override
	public boolean toBoolean() {
		return !this.evaluate().isEmpty();
	}
	
	@Override
	public int toInt() {
		return this.evaluate().length();
	}
	
	@Override	
	public String toString() {
		return this.evaluate();
	}

}
