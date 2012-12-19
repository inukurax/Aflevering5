
import spreadsheet.NoSuchSpreadsheetException;
import ui.command.*;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ui.CommandInterpreter;
import ui.command.FailedCommand;

final class Interpreter {

  private final Scanner scanner;

  /**
   * Initializes a scanner to scan
   * system input in the console.
   */
  private Interpreter() {
    this.scanner = new Scanner(System.in);
  }

  /**
   * Writes ">" to console when ready for input
   * checks for empty input
   * loops until exit command
 * @throws NoSuchSpreadsheetException 
   */
  public void prompt() throws NoSuchSpreadsheetException {
    String command = null;
    while(true) {
      System.out.print("> ");
      command = this.scanner.nextLine();
      if (!command.isEmpty())
      CommandInterpreter.interpret(new Scanner(command)).execute();

    }
    
  }

  public static void main(String[] _) throws NoSuchSpreadsheetException {
		  new Interpreter().prompt();
  }

}
