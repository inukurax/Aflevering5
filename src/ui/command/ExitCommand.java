package ui.command;

import spreadsheet.Application;

public final class ExitCommand
    extends Command {
	  /**
	   * Terminates the program
	   */

  public void execute() {
	  System.out.println("Terminating application!");
      Application.instance.exit();
  }

}
