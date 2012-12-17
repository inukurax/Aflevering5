package ui;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import ui.command.Command;
import ui.command.ExitCommand;
import ui.command.FailedCommand;

import spreadsheet.*;
import spreadsheet.arithmetic.*;

public final class CommandInterpreter {

  private CommandInterpreter() {
    // The class should not be instantiated.
  }

  public static Command interpret(final Scanner scanner) {
    final String keyword = scanner.next();
    
    switch(keyword.toLowerCase()) {
      case "exit":
        return new ExitCommand();
    }
    return new FailedCommand(
      String.format("Illegal start of command, \"%s\".", keyword));
  }

}
