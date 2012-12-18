package ui.command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import spreadsheet.NoSuchSpreadsheetException;
import ui.ErrorStream;

public class SaveCommand extends Command {
	
	public static ArrayList<String> saveFile; // this or a class? or arraylist
	private BufferedWriter output;
	private String filename;
	/**
	 * Does nothing right now
	 * @param filename
	 */
	public SaveCommand(String filename) {
		this.filename = filename;
	}

	@Override
	public void execute() {
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
	}

}
