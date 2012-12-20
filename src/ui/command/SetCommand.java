package ui.command;


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
import ui.SaveFile;

public final class SetCommand extends Command {

	private int argInt1;
	private int argInt2;
	private String expType;
	private String arguments;
	private String fatTest = "";
	private final static String constRegex ="((AConst)|(LConst)|(TConst))";
	/**
	 * @param argInt1
	 * @param argInt2
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
			expression = getExpression(expType, arguments);
		if (expression != null) {
			arguments = arguments.replaceAll(fatTest, "");
			Application.instance.getWorksheet().set(position, expression);
			System.out.println(String.format("set new %s(%s) at Position(%d,%d)"
					, expType, arguments, argInt1, argInt2));
			SaveFile.saveFile.add(String.format("set %d %d %s %s"
					,  argInt1, argInt2,expType, arguments));
		}
		else {
			ErrorStream.instance.show("Invalid Expression: " + 
					String.format("new %s(%s) ", expType, arguments));
		}
	}
	
	private Expression getExpression(String expType, String arg) {
		Pattern constPattern = Pattern.compile(constRegex);

		Scanner scan = new Scanner(arg);
		try {
		switch (expType) { 
		case "AConst" : if (scan.hasNextInt()) {
							int tal = scan.nextInt();
							if (scan.hasNextLine())
								fatTest = scan.nextLine();
							return new AConst(tal);
						}
						return null;
		case "LConst" : if (scan.hasNextBoolean()) {
							boolean bool = scan.nextBoolean();
							if (scan.hasNextLine())
								fatTest = scan.nextLine();
							return new LConst(bool);
						}
						return null;
		case "TConst" : if (scan.hasNext()) {
							String str = scan.next();
							if (scan.hasNextLine())
								fatTest = scan.nextLine();
							return new TConst(str);
						}
						return null;
		case "CellReference" : if (scan.findInLine("(\\w+) (\\d+) (\\d+)") != null) {
								MatchResult result = scan.match();
								String sheetName = result.group(1);
								int argInt1 = Integer.parseInt(result.group(2));
								int argInt2 = Integer.parseInt(result.group(3));
								Position pos = new Position(argInt1, argInt2);
								Spreadsheet sheet = Application.instance.
										getSpreadsheet(sheetName);
								return new CellReference(sheet, pos);
							}
							return null;
			
		case "Neg" : if (scan.findInLine(constPattern) != null ) {
						    MatchResult result = scan.match();
						    String type2 = result.group(1);
						    if (scan.hasNextLine())
						return new Neg(getExpression(type2, scan.nextLine()));
					 	}
						return null;

		case "Add" : String[] argSplit = splitTwoArg(arg);
					 return new Add(getExpression(argSplit[0],argSplit[1]),
							 getExpression(argSplit[2],  argSplit[3]));
					 
		case "Concat" : String[] argSplit2 = splitTwoArg(arg);
						return new Add(getExpression(argSplit2[0],argSplit2[1]),
								getExpression(argSplit2[2],  argSplit2[3]));
						
		}
		} catch (Exception e ) {
			ErrorStream.instance.show("Invalid input: " + e.toString());
		}
		return null;
		
	}
	
	/**
	 * method for Concat and Add
	 * Splits a String in to a list of first argument and second.
	 * This is needed because Concat and Add takes two arguments.
	 * @param str an console input for Add or Concat
	 * @return should return String[] of length() == 4 
	 *         index 0 = expression type of argument 1 of Add or Concat
	 * 		   index 1 = index 0's arguments
	 * 		   index 2 =  expression type of argument 2 of Add or Concat
	 * 		   index 3 = index 2's arguments
	 */
	private static String[] splitTwoArg(String str) {
		String[] list = str.split(" ");
		int countConst = 0;
		int countDuo = 1;
		final String constRegex ="((AConst)|(LConst)|(TConst))";
		final String duoRegex ="(Concat)|(Add)";
		String newString = "";
		String newStringName = "";

		int i;
		for (i = 0; countDuo > countConst && i < list.length; i++) {
			if (list[i].matches(constRegex)) {
				countConst++;
			}
			if (list[i].matches(duoRegex)) {
				countDuo++;
			}
			if (i == 0) 
			newStringName = list[i];	
			
			else
			newString = newString + list[i] + " ";	

		}
		newString = newString + list[i];
		String rest = "";
		for (i = i+1; i < list.length; i++) {
			rest = rest + " " + list[i];
		}
		rest = rest.replaceFirst(" ", "");

		String restName = rest.substring(0, rest.indexOf(" "));
		rest = rest.substring(rest.indexOf(" "), rest.length());
		rest = rest.replaceFirst(" ", "");

		String[] split = {newStringName, newString ,restName ,rest};
		return split;
	}

}
