package ui;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import ui.command.*;


import spreadsheet.*;
import spreadsheet.arithmetic.*;

public final class CommandInterpreter {
	private final static String commandRegex = 
			"(\\d+) (\\d+) ((Add)|(AConst)|" +
			" (Neg)|(LConst)|(Conjunct)|(Disjunct)" +
			"|(Not)|(TConst)|(Concat))";

  private CommandInterpreter() {
    // The class should not be instantiated.
  }
 /**
  * 
  * pws prints the current worksheet name;
  * ns initializes a new spreadsheet;
  * ls list initialized spreadsheets;
  * cws changes the worksheet to the given spreadsheet;
  * set sets the given expression at 
  * 	the given position in the current worksheet.
  * get gets the expression at the
  * 	 given position in the current worksheet
  * @param scanner
  * @return the Command equal to the input in console.
  *  if no match, writes out invalid Command.
  */
  public static Command interpret(final Scanner scanner) {
    final String keyword = scanner.next();

    switch(keyword) {
    case "pws" : return new PrintCurrentCommand();
    case "ns"  : return new NewSpreadsheetCommand();
    case "ls"  : return new ListSpreadsheetsCommand();
    case "cws" : if (scanner.hasNext()) 
				    return new ChangeWorksheetCommand(scanner.next()); 
    			 return new ChangeWorksheetCommand("");
    case "get" : if (scanner.findInLine("(\\d+) (\\d+)") != null) {
				    MatchResult result = scanner.match();
				    int argInt1 = Integer.parseInt(result.group(1));
				    int argInt2 = Integer.parseInt(result.group(2));
        
					return new GetCommand(argInt1, argInt2);
    			 }
    			 return new FailedCommand("Syntax error: \"get 0 0\"");
    case "set" : Pattern x = Pattern.compile(commandRegex);
    	
    			 if (scanner.findInLine(x) != null) {
					    MatchResult result = scanner.match();
					    int argInt1 = Integer.parseInt(result.group(1));
					    int argInt2 = Integer.parseInt(result.group(2));
					    String type = result.group(3);
					    String rest = "";
					    if (scanner.hasNextLine())
					    rest = scanner.nextLine();

					    return new SetCommand(argInt1, argInt2, type, rest);
				    }
				 return new FailedCommand("Syntax error: \"set 0 0 Aconst 2\"");

    case "save" : if (scanner.hasNext()) {
    			  	String file = scanner.next();
    			  	int length = file.length();
    			  	if (length > 4) {
    			  	String type = file.substring(length - 4, length);
    			  	if (type.equals(".ark"))
    			  		return new SaveCommand(file);
    			  	}
    			  }
    			  return new FailedCommand("Need argument: \"save filename.ark\"");
    case "load" : if (scanner.hasNext()) {
    				String file = scanner.next();
    					int length = file.length();
    					if (length > 4) {
	  	String type = file.substring(length - 4, length);
	  	if (type.equals(".ark"))
	  		return new LoadCommand(file);
	  	}
	  }
    return new FailedCommand("Need argument: \"load filename.ark\"");
    case "exit" : return new ExitCommand();
    }
    
    return new FailedCommand(
                   String.format("Illegal start of command, \"%s\".", keyword));
  }

  
}
