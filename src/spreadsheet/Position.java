package spreadsheet;

public final class Position {
    private int column;
    private int row;

    /**
     * Constructs a Position with a row and column value
     * @param column is a non negative int
     * @param row is a non negative int
     */
    public Position(final int column, final int row){

        this.column = column;
        this.row = row;

    }

    /**
     * Accessor method for getting column
     * @return column
     */
    public int getColumn(){
        return column;
    }
    
    /**
     * Accessor method for getting row
     * @return row
     */
    public int getRow(){
        return row;
    }

    /**
     * Accessor method 
     * @param other
     * @return returning whether Position mathces 
     * another Position
     */
    public boolean isEqualTo(final Position other){
    	if (other == null)
    		return false;
        return (other.getRow() == getRow() && other.getColumn() == getColumn());
    }

}