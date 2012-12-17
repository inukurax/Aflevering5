package spreadsheet;

import java.util.ArrayList;

/** A singleton class representing a spreadsheet application.
 *
 * The instance is initialized on first mention of the class.
 */
public final class Application {

  private ArrayList<Spreadsheet> spreadsheets;
  private Spreadsheet worksheet;

  public static final Application instance = new Application();

  private Application() {
    this.worksheet = new Spreadsheet();
    this.spreadsheets = new ArrayList<Spreadsheet>();
    this.spreadsheets.add(this.worksheet);
  }
	
	/**
	 * returns the current worksheet;
	 *  guaranteed to be be not null;
	 * @return
	 */
	public Spreadsheet getWorksheet() {
		return worksheet;
	}
	/**
	 *  initializes a new empty spreadsheet; 
	 *  the worksheet is retained;
	 */
	public void newSpreadsheet() {
	    this.spreadsheets.add(new Spreadsheet());
	}
	
	/**
	 *  changes the worksheet to be the given spreadsheet; 
	 *  throws NoSuchSpreadsheetException 
	 *  if there is no spreadsheet by the specified name;
	 * @param name
	 * @throws NoSuchSpreadsheetException 
	 */
	public void changeWorksheet(final String name) 
			      throws NoSuchSpreadsheetException {
		if (worksheet.getName().equals(name))
			return;
		
		for (Spreadsheet sheet : spreadsheets) {
			if (sheet.getName().equals(name)) {
				this.worksheet = sheet;
				return;
			}
		}
		throw new NoSuchSpreadsheetException(name);
		
	}
	
	/**
	 * returns a reference to the desired spreadsheet;
	 * throws NoSuchSpreadsheetException 
	 * if there is no spreadsheet by the specified name;
	 * @param name
	 * @return
	 * @throws NoSuchSpreadsheetException 
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
	 * lists the currently active spreadsheets;
	 * @return
	 */
	public Iterable<String> listSpreadsheets() {
		return (Iterable<String>) spreadsheets.listIterator();
		
	}
	/**
	 * exits the application with exit code 0.
	 */
	public void exit() {
		System.exit(0);
	}

}
