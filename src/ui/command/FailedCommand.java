package ui.command;

import ui.ErrorStream;

public final class FailedCommand
    extends Command {

  private final String message;
  /**
   * @param message of String
   */

  /* Assumes that message is not null. */
  public FailedCommand(final String message) {
    this.message = message;
 }
  /**
   * used to create string
   * that can be printed to user
   * in case of wrong input
   */

  public void execute() {
    ErrorStream.instance.show(this.message);
  }

}
