
import ui.command.*;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ui.CommandInterpreter;
import ui.command.FailedCommand;

final class Interpreter {

  private final Scanner scanner;

  private Interpreter() {
    this.scanner = new Scanner(System.in);
  }

  /**
   * Writes ">" to console when ready for input
   * checks for empty input
   * loops until exit command
   */
  public void prompt() {
    String command = null;
    while(true) {
      System.out.print("> ");
      command = this.scanner.nextLine();
      if (!command.isEmpty())
      CommandInterpreter.interpret(new Scanner(command)).execute();

    }
    
  }

  public static void main(String[] _) {
		  new Interpreter().prompt();
  }

}
