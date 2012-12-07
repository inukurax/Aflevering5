package spreadsheet; 

/**
 * 
 * Abstract class for Expressions of the type 
 * Integer, Boolean and String
 * Holds 3 abstract methods for converting the different types
 */
public abstract class Expression {
	
	public abstract boolean toBoolean();
	
	public abstract int toInt();
	
	public abstract String toString();

		
}