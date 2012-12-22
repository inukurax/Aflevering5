package ui.command;

import spreadsheet.Application;
import ui.SaveFile;

public final class NewSpreadsheetCommand extends Command {
	/**
	 * Creates a new Spreadsheet 
	 * Giving it the sequencial name
	 */
	public void execute() {
		Application.instance.newSpreadsheet();
		System.out.println("- made new spreadsheet, named: " 
		+ Application.instance.getLast().getName());
		SaveFile.saveFile.add("ns");
	}

}
