package ui.command;

import spreadsheet.Application;
import spreadsheet.NoSuchSpreadsheetException;
import ui.ErrorStream;
import ui.SaveFile;

public final class ChangeWorksheetCommand extends Command {

	private final String name;
	
	/**
	 * 
	 * @param name of Spreadsheet
	 */

	  /* Assumes that name is not null. */
	public ChangeWorksheetCommand (final String name) {
	    this.name = name;
	    /**
	     * gets a String (name) 
	     * of an already created speadsheet
	     */
	}
	@Override
	public void execute() {
		if (name.isEmpty()) {
		ErrorStream.instance.show("Please use syntax \"cws Sheet#\" ");	
			return;
		}

		try {
			Application.instance.changeWorksheet(name);
			SaveFile.saveFile.add("cws " + name);
		} catch (NoSuchSpreadsheetException e) {
			ErrorStream.instance.show(e.toString());
		}
		/**
		 * Changes Worksheet to the
		 * spreadsheet with the given name
		 * if no spreadsheet with given name is found
		 * it uses exception "NoSuchSpreadsheetException"
		 */
	}

}
