package ui.command;

import spreadsheet.Application;

public final class ListSpreadsheetsCommand extends Command {

	public void execute() {
		Iterable<String> list= Application.instance.listSpreadsheets();

		for (String str : list) {
			System.out.println(str);
		}
	}

}
