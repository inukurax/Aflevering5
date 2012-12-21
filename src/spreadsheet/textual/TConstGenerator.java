package spreadsheet.textual;

import spreadsheet.ExpressionGenerator;
import spreadsheet.ExpressionInfo;

/** A generator fo the TConst class */
public class TConstGenerator extends ExpressionGenerator {

	/**
	 * Generates a random TConst Expression
	 * @return ExpressionInfo about the newly made TConst Expression
	 */
	@Override
	public ExpressionInfo next() {
		final String value = this.strGen.next();
		final TConst tConst = new TConst(value);
		return new ExpressionInfo(tConst, value);
		
	}

}
