package ui;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import ui.command.*;


import spreadsheet.*;
import spreadsheet.arithmetic.*;

public final class CommandInterpreter {

  private CommandInterpreter() {
    // The class should not be instantiated.
  }
 /**
  * pws prints the current worksheet name;
  * ns initializes a new spreadsheet;
  * ls list initialized spreadsheets;
  * cws changes the worksheet to the given spreadsheet;
  * set sets the given expression at 
  * 	the given position in the current worksheet.
  * get gets the expression at the
  * 	 given position in the current worksheet
  * @param scanner
  * @return
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
    case "get" : if (scanner.hasNextInt() ) {
				    int argInt1 = scanner.nextInt();
					if  (scanner.hasNextInt()) {
					    int argInt2 = scanner.nextInt();
					    return new GetCommand(argInt1, argInt2);
					}
				  }
    			 return new FailedCommand("get need 2 arguments of type int.");
    case "set" :   return new SetCommand();
    case "save" : if (scanner.hasNext()) {
    			  	String file = scanner.next();
    			  	int length = file.length();
    			  	if (length > 4) {
    			  	String type = file.substring(length - 4, length);
    			  	if (type.equals(".ark"))
    			  		return new SaveCommand(file);
    			  	}
    			  }
    			  return new FailedCommand("need argument of filename.ark");
    case "exit" : return new ExitCommand();
    }
    
    return new FailedCommand(
      String.format("Illegal start of command, \"%s\".", keyword));
  }

  
}
