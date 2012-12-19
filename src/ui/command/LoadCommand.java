/**
 * 
 */
package ui.command;

import spreadsheet.NoSuchSpreadsheetException;

public class LoadCommand extends Command {

	
	private final String filename;
	/**
	 * @param file
	 */
	public LoadCommand(String file) {
		this.filename = file;
	}

	@Override
	public void execute() throws NoSuchSpreadsheetException {
		System.out.println("Loading file: "+ filename);
	}

}
