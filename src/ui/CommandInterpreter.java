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
				 else
				    return new ChangeWorksheetCommand("");
    case "exit": return new ExitCommand();
    }
    
    return new FailedCommand(
      String.format("Illegal start of command, \"%s\".", keyword));
  }

}
