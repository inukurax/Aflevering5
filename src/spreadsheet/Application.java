package spreadsheet;

import java.util.ArrayList;

/** A singleton class representing a spreadsheet application.
 *
 * The instance is initialized on first mention of the class.
 */
public final class Application {
  
  private ArrayList<Spreadsheet> spreadsheets;
  private Spreadsheet worksheet;
  private ArrayList<String> list;


  public static final Application instance = new Application();

  private Application() {
    this.worksheet = new Spreadsheet();
    this.spreadsheets = new ArrayList<Spreadsheet>();
    this.spreadsheets.add(this.worksheet);
	this.list = new ArrayList<String>();
	this.list.add(worksheet.getName());
  }
	
	/**
	 * Returns the current worksheet;
	 *  guaranteed to be be not null;
	 * @return
	 */
	public Spreadsheet getWorksheet() {
		return worksheet;
	}
	/**
	 *  Initializes a new empty spreadsheet; 
	 *  the worksheet is retained;
	 */
	public void newSpreadsheet() {
	    this.spreadsheets.add(new Spreadsheet());
	    String name = spreadsheets.get(spreadsheets.size() - 1).getName();
	    this.list.add(name);
	}
	
	/**
	 *  Changes the worksheet to be the given Spreadsheet by name; 
	 *  throws NoSuchSpreadsheetException 
	 *  if there is no spreadsheet by the specified name;
	 * @param name of Spreadsheet
	 * @throws NoSuchSpreadsheetException if no Spreadsheet by name
	 * is found
	 */
	public void changeWorksheet(final String name) 
			      throws NoSuchSpreadsheetException {
		if (worksheet.getName().equals(name))
			return;
		this.worksheet = this.getSpreadsheet(name);	
	}
	
	/**
	 * Returns a reference to the desired spreadsheet;
	 * throws NoSuchSpreadsheetException 
	 * if there is no spreadsheet by the specified name;
	 * @param name of Spreadsheet to get.
	 * @return the Spreadsheet with name
	 * @throws NoSuchSpreadsheetException if no Spreadsheet by name
	 * is found
	 */
	public Spreadsheet getSpreadsheet(final String name) 
						throws NoSuchSpreadsheetException {
		for (Spreadsheet sheet : spreadsheets) {
			if (sheet.getName().equals(name))
				return sheet;
		}
		throw new NoSuchSpreadsheetException(name);
	}
	
	/**
	 * list of the currently active spreadsheets;
	 * @return List of Spreadsheet names
	 */
	public Iterable<String> listSpreadsheets() {
		 return list;	
	}
	/**
	 * exits the application with exit code 0.
	 */
	public void exit() {
		System.exit(0);
	}
	
	/**
	 * Gets the last made Spreadsheet
	 * @return
	 */
	public Spreadsheet getLast() {
		int index = spreadsheets.size() - 1;
		return spreadsheets.get(index);
	}
	
	/**
	 * Sets Application as it was initializes again.
	 * also sets count of Spreadsheet class, so name of new Spreadsheet
	 * will start at Sheet0 and go to Sheet<count++>
	 */
	public void restart() {
		this.spreadsheets.clear();
		this.list.clear();
		Spreadsheet.count = 0;
		this.worksheet = new Spreadsheet();
		this.spreadsheets.add(this.worksheet);
		this.list.add(this.worksheet.getName());
	}

}
