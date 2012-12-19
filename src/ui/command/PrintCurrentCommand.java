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

}
