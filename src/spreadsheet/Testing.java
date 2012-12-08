package spreadsheet;

import spreadsheet.arithmetic.*;
import spreadsheet.logical.*;
import spreadsheet.textual.*;

public class Testing {
	
  public static void main(String[] args) {
	     Spreadsheet spreadsheet = new Spreadsheet();
	     // Create an expression for the first cell
	     Expression e1 =
	       new Conjunct(new LConst(true), new TConst(""));
	     Expression e2 =
	       new Disjunct(new LConst(false), new TConst("true"));
	     Expression efoo = new Add(e1, e2);
	     // Create an expression for the second cell
	     Expression e4 = new AConst(41);
	     Expression ebar = new Add(e4, efoo);
	     spreadsheet.set(new Position(1, 1), ebar);


	     Expression e3 = new CellReference(spreadsheet, new Position(1, 1));

    System.out.println(e3.toInt());

  }
}