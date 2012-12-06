package spreadsheet.logical;

import spreadsheet.Expression;

public abstract class Logical extends Expression {
	
	public abstract boolean evaluate();

	@Override
	public boolean toBoolean() {
		return this.evaluate();
	}
	
	@Override
	public int toInt() {
		if (this.evaluate())
			return 1;
		else
			return 0;
	}
	
	@Override	
	public String toString() {
		if (this.evaluate()) 
			return "true";
		else 
			return "";	
	
	}
}
