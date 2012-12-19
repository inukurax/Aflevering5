package ui.command;

import java.beans.Expression;

import spreadsheet.Application;
import spreadsheet.NoSuchSpreadsheetException;
import spreadsheet.Position;
import spreadsheet.arithmetic.AConst;

public final class SetCommand extends Command {

	private int argInt1;
	private int argInt2;
	private int expType;
	@Override
	public void execute() throws NoSuchSpreadsheetException {
		Position position = new Position(1, 2);
		AConst expression = new AConst(2);
		Application.instance.getWorksheet().set(position, expression);
	}

}
