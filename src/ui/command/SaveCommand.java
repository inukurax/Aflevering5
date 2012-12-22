package ui.command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ui.ErrorStream;
import ui.SaveFile;

public final class SaveCommand extends Command {
	
	// stores what needs to be saved.
	private BufferedWriter output;
	private String filename;
	/**
	 * 
	 * @param filename of String
	 */
	public SaveCommand(String filename) {
		this.filename = filename;
	}
	/**
	 * gets a String saved for 
	 * use in execution
	 */

	@Override
	public void execute() {
		ArrayList<String> saveFile;
		saveFile = SaveFile.saveFile;
		try {
			if (saveFile != null && !saveFile.isEmpty()) {
			
				output = new BufferedWriter(new FileWriter(filename, true));
			
				for (String str : saveFile) {
				output.write(str);
				output.newLine();
				}
				System.out.println("Saved file to: "  + filename);
				output.close();
			}
			else
				System.out.println("Nothing to save!");
		} 
		catch (IOException e) {
			ErrorStream.instance.show("There was an error, " + e.toString());
		}
		/**
		 * Prints the array saveFile
		 * to text file, thus saving
		 * commands used in the session
		 * 
		 * if nothing has been done this session
		 * returns "Nothing to save!"
		 * 
		 * catches IOExecption should there be
		 * and error saving file, returning error message
		 */
	}

}
