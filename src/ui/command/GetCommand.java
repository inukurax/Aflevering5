package ui.command;

import spreadsheet.Application;
import spreadsheet.NoSuchSpreadsheetException;
import spreadsheet.Position;

public class GetCommand extends Command {
	
	private Position pos;

	public GetCommand(final int arg1, final int arg2) {

		Position pos = new Position(arg1, arg2);
	}
	@Override
	public void execute() throws NoSuchSpreadsheetException {
		
		try {
		String str = Application.instance.getWorksheet().get(pos).toString();
		System.out.println(str);
		}
		catch (NullPointerException e) {
			System.out.println("Null expression found " + e.toString());
		}
	}

}
