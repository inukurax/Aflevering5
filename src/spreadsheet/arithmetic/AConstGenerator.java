package spreadsheet.arithmetic;

import spreadsheet.ExpressionGenerator;
import spreadsheet.ExpressionInfo;

/** A generator for the AConst class */
public class AConstGenerator extends ExpressionGenerator {

	/**
	 * Generates a random AConst Expression
	 * @return ExpressionInfo about the newly made AConst Expression
	 */
	@Override
	public ExpressionInfo next() {
		final int value = this.intGen.next();
		final AConst aConst = new AConst(value);
		return new ExpressionInfo(aConst, value);
	}
}