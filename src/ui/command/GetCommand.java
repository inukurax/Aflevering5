package ui.command;

import spreadsheet.Application;
import spreadsheet.CellReference;
import spreadsheet.NoSuchSpreadsheetException;
import spreadsheet.Position;
import ui.ErrorStream;
import ui.SaveFile;

public final class GetCommand extends Command {
	
	private Position pos;
	private int arg1;
	private int arg2;

	public GetCommand(int arg1, int arg2) {
		this.pos = new Position(arg1, arg2);
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
	public void execute() throws NoSuchSpreadsheetException {
		if (Application.instance.getWorksheet().isCyclic()) 
			System.out.println("Cyclic expression");
		else {
		try {
			String str = Application.instance.getWorksheet().get(pos).toString();
			System.out.println(str);
			String save = String.format("get %s %s", arg1,arg2);
			SaveFile.saveFile.add(save);
		
			//	System.out.println("Cyclic expression");

		}
		catch (NullPointerException e) {
			ErrorStream.instance.show(String.format("Null expression at %s %s -> "+ e.toString(), arg1,arg2));
		} 
		}
	}

}
