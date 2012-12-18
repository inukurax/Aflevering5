package ui.command;

import spreadsheet.Application;

public class ListSpreadsheetsCommand extends Command {

	@Override
	public void execute() {
		Iterable<String> list= Application.instance.listSpreadsheets();

		for (String str : list) {
			System.out.println(str);
		}
	}

}
