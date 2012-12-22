/**
 * 
 */
package ui.command;

import spreadsheet.Application;

public final class PrintCurrentCommand extends Command {

	public void execute() {
		String str = Application.instance.getWorksheet().getName();
		System.out.println(str);
	}
/** 
 * Prints the name of the worksheet
 * as there will always be 1 and only 1
 */
}
