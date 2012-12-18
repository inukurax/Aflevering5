package ui.command;

import spreadsheet.Application;
import ui.SaveFile;

public class NewSpreadsheetCommand extends Command {

	public void execute() {
		Application.instance.newSpreadsheet();
		System.out.println("- made new spreadsheet, named: " 
		+ Application.instance.getLast().getName());
		SaveFile.saveFile.add("ns");
	}

}
