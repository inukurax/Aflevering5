package ui.command;

import java.beans.Expression;

import spreadsheet.Application;
import spreadsheet.NoSuchSpreadsheetException;
import spreadsheet.Position;
import spreadsheet.arithmetic.AConst;

public final class SetCommand extends Command {

	private int argInt1;
	private int argInt2;
	private String expType;
	private String arguments;
	/**
	 * @param argInt12
	 * @param argInt22
	 * @param type
	 * @param rest
	 */
	public SetCommand(final int argInt1, final int argInt2, 
			final String type, final String rest) {
		this.argInt1 = argInt1;
		this.argInt2 = argInt2;
		this.expType = type;
		this.arguments = rest;
		
	}
	@Override
	public void execute() throws NoSuchSpreadsheetException {
		Position position = new Position(1, 2);
		AConst expression = new AConst(2);
		Application.instance.getWorksheet().set(position, expression);
		System.out.println(String.format("pos (%d,%d) exp: %s + rest:%s", argInt1,argInt2,expType, arguments));
	}

}
