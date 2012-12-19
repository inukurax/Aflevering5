package ui.command;


import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import spreadsheet.Application;
import spreadsheet.NoSuchSpreadsheetException;
import spreadsheet.Position;
import spreadsheet.arithmetic.*;
import spreadsheet.logical.*;
import spreadsheet.textual.*;
import spreadsheet.*;
import ui.ErrorStream;

public final class SetCommand extends Command {

	private int argInt1;
	private int argInt2;
	private String expType;
	private String arguments;
	private String fatTest = "";
	private final static String constRegex ="((AConst)|(LConst)|(TConst))";
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
		Expression expression;
			expression = getType(expType, arguments);
		if (expression != null) {
			arguments = arguments.replaceAll(fatTest, "");
			Application.instance.getWorksheet().set(position, expression);
			System.out.println(String.format("set new %s(%s) at Position(%d,%d)"
					, expType, arguments, argInt1, argInt2));
		}
		else {
			ErrorStream.instance.show("Invalid Expression: " + 
					String.format("new %s(%s) ", expType, arguments));
		}
	}
	
	private Expression getType(String type, String arg) {
		Pattern constPattern = Pattern.compile(constRegex);

		Scanner scan = new Scanner(arg);
		try {
		switch (type) { 
		case "AConst" : if (scan.hasNextInt()) {
							int tal = scan.nextInt();
							if (scan.hasNextLine())
								fatTest = scan.nextLine();
							return new AConst(tal);
						}
						return null;
		case "LConst" : if (scan.hasNextBoolean())
							return new LConst(scan.nextBoolean());
						return null;
		case "TConst" : if (scan.hasNext())
							return new TConst(scan.next());
						return null;
		case "Neg" : if (scan.findInLine(constPattern) != null ) {
						    MatchResult result = scan.match();
						    String type2 = result.group(1);
						    if (scan.hasNextLine())
						return new Neg(getType(type2, scan.nextLine()));
					 	}
						return null;

		/*
		case "Add" :  return new Add(getType("Add", arguments),
				getType("Add", arguments));
		 */
		}
		} catch (NoSuchElementException e) {
			ErrorStream.instance.show("Invalid input: " + e.toString());
			
		}
		return null;
		
	}

}
