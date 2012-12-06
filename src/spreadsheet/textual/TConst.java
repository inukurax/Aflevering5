package spreadsheet.textual;

public class TConst extends Textual {

	private String value;
	
	public TConst(final String string) {
		value = string;
	}
	
	@Override
	public String evaluate() {
		return this.value;
	}
	

}
