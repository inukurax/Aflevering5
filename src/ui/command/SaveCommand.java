package ui.command;

import spreadsheet.NoSuchSpreadsheetException;

public class SaveCommand extends Command {
	
	
	/**
	 * Does nothing right now
	 * @param filename
	 */
	public SaveCommand(String filename) {
		System.out.println("Saved file to: "  + filename);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
