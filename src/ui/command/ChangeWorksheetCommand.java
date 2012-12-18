package ui.command;

import spreadsheet.Application;
import spreadsheet.NoSuchSpreadsheetException;
import ui.SaveFile;

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
			SaveFile.saveFile.add("cws" + name);
		} catch (NoSuchSpreadsheetException e) {
			System.out.println(e.toString());
		}
	}

}
