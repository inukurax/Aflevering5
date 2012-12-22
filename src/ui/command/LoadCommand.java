/**
 * 
 */
package ui.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import spreadsheet.Application;
import spreadsheet.NoSuchSpreadsheetException;
import ui.CommandInterpreter;
import ui.ErrorStream;

public class LoadCommand extends Command {

	
	private final String filename;
	/**
	 * @param file of String
	 */
	public LoadCommand(String file) {
		this.filename = file;
	}
	/**
	 * gets String reference to
	 * a previously saved file
	 */

	@Override
	public void execute() {
		try {
			Application.instance.restart();
			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNextLine()) {
				
				String nextLine = scanner.nextLine();
				if (!nextLine.isEmpty())
			CommandInterpreter.interpret(new Scanner(nextLine)).execute();
			}
			scanner.close();
			System.out.println("Loaded file: "+ filename);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		ErrorStream.instance.show("Error: " + e.toString());
		}
		/**
		 * Scans a text file for commands
		 * used in a previous session
		 * and writes each command 
		 * to program
		 * 
		 * if no file has the given name
		 * Catches exception returning error to user
		 */
		
		
	}

}
