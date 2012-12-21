package ui;

public final class ErrorStream {

  public static final ErrorStream instance = new ErrorStream();

	  private ErrorStream() {
	    // This is a singleton.
	  }
	/**
	 * Prints error message to console.
	 * @param text error message!
	 */
	  public void show(final String text) {
	    System.err.println(text);
	  }

}
