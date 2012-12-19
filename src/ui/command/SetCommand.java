package ui.command;


import spreadsheet.Application;
import spreadsheet.NoSuchSpreadsheetException;
import spreadsheet.Position;
import spreadsheet.arithmetic.*;
import spreadsheet.logical.*;
import spreadsheet.textual.*;
import spreadsheet.*;

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
		Position position = new Position(argInt1, argInt2);
		Expression expression = this.getType(expType);
		Application.instance.getWorksheet().set(position, expression);
		System.out.println(String.format("set new %s(%s) " +
				"at Position(%d,%d)",expType, arguments,argInt1,argInt2));
	}
	
	private Expression getType(String str) {
		switch (str) {
		case "AConst" : return new AConst(Integer.parseInt(arguments));
		case "LConst" : return new LConst(Boolean.parseBoolean(arguments));
		case "TConst" : return new TConst(arguments);
		case "Add" : return new Add(getType(arguments),getType(arguments));
		case "Neg" : return new Neg(getType(arguments));


		}
		return null;
		
	}

}
