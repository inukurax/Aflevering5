package ui.command;

import spreadsheet.NoSuchSpreadsheetException;

public abstract class Command {

  public abstract void execute() throws NoSuchSpreadsheetException;

}
