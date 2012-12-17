package ui.command;

import spreadsheet.Application;
import ui.ErrorStream;

public final class FailedCommand
    extends Command {

  private final String message;

  /* Assumes that message is not null. */
  public FailedCommand(final String message) {
    this.message = message;
 }

  public void execute() {
    ErrorStream.instance.show(this.message);
  }

}
