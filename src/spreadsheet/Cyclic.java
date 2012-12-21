package spreadsheet;

import java.util.ArrayList;

public class Cyclic {
	
	// Holds Position of CellReference. Only adds entries in SetCommand
	private ArrayList<Position> positionList;
	// Holds Position that CellReference points to. Only adds entries in SetCommand 
	private ArrayList<Position> cellList;
	
	/**
	 * Construct a Cyclic object holding a list of Position from set
	 * and a list of CellReferences Positions.
	 */
	public Cyclic() {
		positionList = new ArrayList<Position>();
		cellList = new ArrayList<Position>();
	}
	
	
	/**
	 * Accesor method for getting positionList.
	 * @return list of Positions with a CellReference Expression
	 */
	public  ArrayList<Position> getPosList() {
		return positionList;
	}
	/**
	 * Accesor method for getting cellList
	 * @return list of Position that CellReference points to.
	 */
	public  ArrayList<Position> getCellList() {
		return cellList;
	}
	
	/**
	 * Runs through every element in the
	 * spreadsheets list of Positions with a CellReferences
	 * and check if it equals any of the elements
	 * in the spreadsheets list of Position added with a CellReference .
	 * expressions
	 * @return true if spreadsheet holds a infinity loop E±xpression.
	 */
	public boolean isCyclic() {
	int i = 0;
	if (this.getCellList().isEmpty() || this.getPosList().isEmpty())
		return false;
	while (i  < this.getCellList().size()) {
		for (Position pos : this.getPosList()) {
			if (this.getCellList().get(i).isEqualTo(pos))
				return true;
		}
		i++;
	}
	return false;
	}

}
