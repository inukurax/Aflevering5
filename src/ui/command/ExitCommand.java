package ui.command;

import spreadsheet.Application;

public final class ExitCommand
    extends Command {

  public void execute() {
	  System.out.println("Terminating application!");
    Application.instance.exit();
  }

}
