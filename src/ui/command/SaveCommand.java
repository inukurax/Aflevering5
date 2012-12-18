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

	/* (non-Javadoc)
	 * @see ui.command.Command#execute()
	 */
	@Override
	public void execute() throws NoSuchSpreadsheetException {
		// TODO Auto-generated method stub

	}

}
