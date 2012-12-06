package spreadsheet;

public class CellReference extends Expression {
	
	private Spreadsheet sheet;
	private Position pos;
	
	public CellReference (final Spreadsheet s, final Position p) {
		   sheet = s;
		   pos = p;
	}
	
	@Override
	public  boolean toBoolean() {
		if (sheet.get(pos) != null)
		  return sheet.get(pos).toBoolean();
		else 
			return false;
	}
	@Override
	public int toInt() {
		if (sheet.get(pos) != null)
			return sheet.get(pos).toInt();
		else 
			return 0;
	}
	@Override
	public String toString() {
		if (sheet.get(pos) != null)
			return sheet.get(pos).toString();
		else 
			return "fail";
	}

}
