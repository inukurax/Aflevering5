package spreadsheet;

public final class Node {
	
	private Position position;
	private Expression expression;
	
  	/**
  	 * Constucts a Node associated with a Postion and an Expression
  	 * @param position is a non null Position
  	 * @param expression is a non null Expression
  	 */
  	public Node (final Position position, final Expression expression) {
  		this.position = position;
  		this.expression = expression;
  	}
  	/**
  	 * 
  	 * @return the Position
  	 */
  	public Position getKey() {
  		return position;
  	}
  	/**
  	 * 
  	 * @return the Expression
  	 */
  	public Expression getValue() {
  		return expression;
  	}
  	/**
  	 * Checks if a Node's Expression and Position
  	 * is equal to another Node's Expression and Position
  	 * @param other a Node to compare with
  	 * @return if two Node are identical
  	 */
  	public boolean isEqualTo(final Node other) {
  		return this.getKey().isEqualTo(other.getKey())
  				&& this.getValue() == other.getValue();
  	}

}