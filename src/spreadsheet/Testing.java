package spreadsheet;

import spreadsheet.*;
import spreadsheet.textual.*;
import spreadsheet.logical.*;
import spreadsheet.arithmetic.*;

public class Testing {
	
  public static void main(String[] args) {
    final Spreadsheet spreadsheet = new Spreadsheet();
    Expression e1 =  new TConst("korrekt");
    Position p1 = new Position(1,1);
    Position p2 = new Position(1,2);

    spreadsheet.set(p1, e1);
    Expression result = spreadsheet.get(p1);
    // Create an expression for the first cell
    Expression ebaz = new Concat(e1, e1);
    Expression e6 = new CellReference(spreadsheet,p1);
    System.out.println(e6.toString());
  }
}