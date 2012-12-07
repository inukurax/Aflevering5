package spreadsheet.arithmetic;

public final class AConst extends Arithmetic {

	private int aConst;
	
	public AConst(int value) {
		this.aConst = value;
	}

	@Override
	public int evaluate() {
		return aConst;
	}


}
