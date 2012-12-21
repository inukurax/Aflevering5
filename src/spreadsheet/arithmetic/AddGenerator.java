package spreadsheet.arithmetic;

import spreadsheet.ExpressionGenerator;
import spreadsheet.ExpressionInfo;

/** A generator for the Add class */
public class AddGenerator extends ExpressionGenerator {

	/**
	 * Generates a random Add Expression
	 * @return ExpressionInfo about the newly made Add Expression
	 */
	@Override
	public ExpressionInfo next() {
		final int val1 = this.intGen.next();
		final int val2 = this.intGen.next();
		final AConst aConst1 = new AConst(val1);
		final AConst aConst2 = new AConst(val2);
		final Add add = new Add(aConst1, aConst2);
		return new ExpressionInfo(add, val1, val2);
	}

}
