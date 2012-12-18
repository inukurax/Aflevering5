package ui.command;

import spreadsheet.Application;

public class NewSpreadsheetCommand extends Command {

	@Override
	public void execute() {
		Application.instance.newSpreadsheet();
		System.out.println("- made new spreadsheet, named: " 
		+ Application.instance.getLast().getName());
	}

}
