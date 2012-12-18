package ui.command;

import spreadsheet.Application;
import spreadsheet.NoSuchSpreadsheetException;

public class ChangeWorksheetCommand extends Command {

	  private final String name;

	  /* Assumes that name is not null. */
	  public ChangeWorksheetCommand (final String name) {
	    this.name = name;
	 }
	@Override
	public void execute() {
		try {
			Application.instance.changeWorksheet(name);
		
		} catch (NoSuchSpreadsheetException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}

}
