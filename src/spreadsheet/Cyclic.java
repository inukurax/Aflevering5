package spreadsheet;

import java.util.ArrayList;
import java.util.Collections;

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
	 * Checks for common elements in cellList and positionList
	 * and checks that <pos> is an already used Position
	 * @param Position to check if it holds a infinity loop
	 * @return true if spreadsheet holds a infinity loop Expression.
	 */
	public boolean isCyclic(Position pos) {
		boolean contains = positionList.contains(pos);
	  return !Collections.disjoint(this.cellList,this.positionList) && contains;
	}


	
}