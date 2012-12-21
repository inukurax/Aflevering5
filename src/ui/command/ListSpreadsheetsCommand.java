package ui.command;

import spreadsheet.Application;

public final class ListSpreadsheetsCommand extends Command {

	public void execute() {
		Iterable<String> nameList = Application.instance.listSpreadsheets();

		for (String str : nameList) {
			System.out.println(str);
		}
	}

}
