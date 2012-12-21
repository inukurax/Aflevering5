package spreadsheet.arithmetic;

import spreadsheet.ExpressionGenerator;
import spreadsheet.ExpressionInfo;

/** A generator for the Neg class */
public class NegGenerator extends ExpressionGenerator {

	/**
	 * Generates a random Neg Expression
	 * @return ExpressionInfo about the newly made Neg Expression
	 */
	@Override
	public ExpressionInfo next() {
		final int value = this.intGen.next();
		final AConst aConst = new AConst(value);
		final Neg neg = new Neg(aConst);
		return new ExpressionInfo(neg, value, "new Neg");
	}
}
