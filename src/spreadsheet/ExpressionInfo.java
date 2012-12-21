package spreadsheet;

import quickcheck.Info;

public class ExpressionInfo extends Info<Expression> {
	
	//Variables used by constructor
	//i is for later case usage
	//name is for storing the name of the Expression
	private int i;
	private String name;
	private String str;
	private String str2;
	private int value;
	private int value2;
	private boolean bool;
	private boolean bool2;


	/**
	 * Here we overload the ExpressionInfo constructor
	 * to make java choose which one is needed
	 * In this case its for AConst Expressions
	 * @param value The value used for AConstGenerator
	 */
	public ExpressionInfo(Expression exp, int value) {
		super(exp);	
		this.value = value;
		name = "new AConst";
		i = 1;
	}
	
	/**
	 * For Neg Expressions
	 * @param value Original value for NegGenerator
	 * @param str Used to make the overload possible
	 * 			  and stores a string with the name
	 */
	public ExpressionInfo(Expression exp, int value, String str) {
		super(exp);
		this.value = value;
		this.name = str;
		i = 2;
	}
	
	/**
	 * For Add Expressions
	 * @param firstOperand First original value for AddGenerator
	 * @param secondOperand Second original value for AddGenerator 
	 * @param str
	 */
	public ExpressionInfo(Expression exp, int firstOperand, int secondOperand) {
		super(exp);
		this.value = firstOperand;
		this.value2 = secondOperand;
		this.name = "New Add";
		i = 3;
	}
	
	/**
	 * For LConst Expressions
	 * @param bool Original value for LConstGenerator
	 */
	public ExpressionInfo(Expression exp, boolean bool) {
		super(exp);
		this.bool = bool;
		name = "new LConst";
		i = 4;
	}

	/**
	 * For Conjunct Expressions
	 * @param bool First original value for ConjunctGenerator
	 * @param bool2 Second original value for ConjunctGenerator
	 */
	public ExpressionInfo(Expression exp, boolean bool, boolean bool2) {
		super(exp);
		this.bool = bool;
		this.bool2 = bool2;
		name = "new Conjunct";
		i = 5;
	}
	
	/**
	 * For Disjunct Expressions
	 * @param bool First original value for ConjunctGenerator
	 * @param bool2 Second original value for ConjunctGenerator
	 * @param str Used to make the overload possible
	 * 			  and stores a string with the name
	 */
	public ExpressionInfo(Expression exp, boolean bool, boolean bool2, String str) {
		super(exp);
		this.bool = bool;
		this.bool2 = bool2;
		this.name = str;
		i = 6;
	}

	/**
	 * For TConst Expressions
	 * @param str Original value for TConstGenerator
	 */
	public ExpressionInfo(Expression exp, String str) {
		super(exp);
		this.str = str;
		this.name = "New TConst";
		i = 7;
	}

	/**
	 * For Concat Expressions
	 * @param str First original value for ConcatGenerator
	 * @param str2 Second original value for ConcatGenerator
	 */
	public ExpressionInfo(Expression exp, String str, String str2) {
		super(exp);
		this.str = str;
		this.str2 = str2;
		this.name = "New Concat";
		i = 8;
	}

	/**
	 * The expected result of a integer Expression
	 * @return integer result
	 */
	public int intResult() {
		switch (i) {
		case 1 : return value;
		case 2 : return value * (-1);
		default: return value + value2;
		}	
	}
	
	/**
	 * The expected result of a boolean Expression
	 * @return boolean result
	 */
	public boolean boolResult() {
		switch (i) {
		case 4 : return bool;
		case 5 : return (bool && bool2);
	    default : return (bool || bool2);
		}
	}
	
	/**
	 * The expected result of a String Expression
	 * @return String result
	 */
	public String strResult() {
		if (i == 1)
			return Integer.toString(value);
		if (i == 7) 
			return str;
		else 
			return (str + str2);
	}
	
	/** Converts to String in format 
	 * "new Expression(Input,input2);" 
	 * for troubleshooting */
	@Override
	public String toString() {
		switch (i) {
		case 1 : return String.format(name + "(%d)", value);
		case 2 : return String.format(name + "(%d)", value);
		case 3 : return String.format(name + "(%d,%d)", value, value2);
		case 4 : return name + " (" + Boolean.toString(bool) + ")";
		case 5 : return name + " (" + Boolean.toString(bool)+ ","
									+ Boolean.toString(bool2)+ ")";
		case 6 : return name + " (" + Boolean.toString(bool)+ ","
									+ Boolean.toString(bool2)+ ")";
		case 7 : return name + " (\"" + str + "\")";
		case 8 : return name + " (\"" + str + "\",\"" + str2 + "\")";
		}
		return null;
	}
}
