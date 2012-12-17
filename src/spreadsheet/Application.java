package spreadsheet;

public final class Application {
	
	/**
	 * returns the current worksheet;
	 *  guaranteed to be be not null;
	 * @return
	 */
	Spreadsheet getWorksheet() {
		return null;
		
	}
	/**
	 *  initializes a new empty spreadsheet; 
	 *  the worksheet is retained;
	 */
	void newSpreadsheet() {
		
	}
	
	/**
	 *  changes the worksheet to be the given spreadsheet; 
	 *  throws NoSuchSpreadsheetException 
	 *  if there is no spreadsheet by the specified name;
	 * @param name
	 */
	void changeWorksheet(final String name) {
		
	}
	
	/**
	 * returns a reference to the desired spreadsheet;
	 * throws NoSuchSpreadsheetException 
	 * if there is no spreadsheet by the specified name;
	 * @param name
	 * @return
	 */
	Spreadsheet getSpreadsheet(final String name) {
		return null;
		
	}
	
	/**
	 * lists the currently active spreadsheets;
	 * @return
	 */
	Iterable<String> listSpreadsheets() {
		return null;
		
	}
	/**
	 * exits the application with exit code 0.
	 */
	void exit() {
		
	}

}
