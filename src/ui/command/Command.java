package ui.command;

import spreadsheet.NoSuchSpreadsheetException;
/**
 * abstract class for all console commands
 */
public abstract class Command {

  public abstract void execute() throws NoSuchSpreadsheetException;

}
