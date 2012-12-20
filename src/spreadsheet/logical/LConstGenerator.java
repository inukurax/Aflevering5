package spreadsheet.logical;

import spreadsheet.ExpressionGenerator;
import spreadsheet.ExpressionInfo;

/** A generator for the LConst class */
public class LConstGenerator extends ExpressionGenerator {

	/**
	 * Generates a random LConst Expression
	 * @return ExpressionInfo about the newly made LConst Expression
	 */
	@Override
	public ExpressionInfo next() {
		final boolean value = this.boolGen.next();
		final LConst lConst = new LConst(value);
		return new ExpressionInfo(lConst, value);
		
	}

}
