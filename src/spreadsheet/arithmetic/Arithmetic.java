package spreadsheet.arithmetic;

import spreadsheet.Expression;

public abstract class Arithmetic extends Expression  {
	
	public abstract int evaluate();

	@Override
	public boolean toBoolean() {
		return this.evaluate() != 0;
	}
	@Override
	public int toInt() {
		return this.evaluate();
	}
	
	@Override	
	public String toString() {
			return "" + this.evaluate();		
	}

}
