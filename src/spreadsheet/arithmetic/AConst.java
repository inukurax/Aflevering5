package spreadsheet.arithmetic;

public class AConst extends Arithmetic {

	private int aConst;
	
	public AConst(int value) {
		this.aConst = value;
	}

	@Override
	public int evaluate() {
		return aConst;
	}


}
