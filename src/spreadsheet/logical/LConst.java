package spreadsheet.logical;

public class LConst extends Logical{
	
	private boolean lConst;
	
	public LConst(boolean value) {
		lConst = value;
	}

	@Override
	public boolean evaluate() {
		return lConst;
	}
}
