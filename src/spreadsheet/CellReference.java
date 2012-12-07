package spreadsheet;

public final class CellReference extends Expression {
	
	private Spreadsheet sheet;
	private Position pos;
	
	public CellReference (final Spreadsheet s, final Position p) {
		   sheet = s;
		   pos = p;
	}
	
	@Override
	public  boolean toBoolean() {
		  return sheet.get(pos).toBoolean();
	}
	@Override
	public int toInt() {
			return sheet.get(pos).toInt();
	}
	@Override
	public String toString() {
			return sheet.get(pos).toString();
	}

}
