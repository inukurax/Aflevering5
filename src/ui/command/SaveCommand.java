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
	 * Does nothing right now
	 * @param filename
	 */
	public SaveCommand(String filename) {
		this.filename = filename;
	}

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
	}

}
