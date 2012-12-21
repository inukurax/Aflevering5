package spreadsheet;

import quickcheck.*;
import spreadsheet.arithmetic.*;
import spreadsheet.logical.ConjunctGenerator;
import spreadsheet.logical.DisjunctGenerator;
import spreadsheet.logical.LConstGenerator;
import spreadsheet.textual.ConcatGenerator;
import spreadsheet.textual.TConstGenerator;

public class ExpressionTest {
	
	
	  private ExpressionGenerator aConstGen;
	  private ExpressionGenerator addGen;
	  private ExpressionGenerator negGen;
	  private ExpressionGenerator lConstGen;
	  private ExpressionGenerator conjunctGen;
	  private ExpressionGenerator disjunctGen;
	  private ExpressionGenerator tConstGen;
	  private ExpressionGenerator concatGen;
	
	  @org.junit.Before
	  public void intializeExpressionGenerator() {
	    this.aConstGen = new AConstGenerator();
	    this.addGen = new AddGenerator();
	    this.negGen = new NegGenerator();
	    
	    this.lConstGen = new LConstGenerator();
	    this.conjunctGen = new ConjunctGenerator();
	    this.disjunctGen = new DisjunctGenerator();
	    
	    this.tConstGen = new TConstGenerator();
	    this.concatGen = new ConcatGenerator();
	    
	  }
	
	  @org.junit.Test
	  public void testAConst() {

	    final Values<ExpressionInfo> infos =
	      new Values<ExpressionInfo>(this.aConstGen);

	    for (final ExpressionInfo info : infos) {
	      final int expected = info.intResult();
	      final int actual = info.getValue().toInt();

	      if (actual == expected) {
	        continue;
	      }

	      System.err.println("AConst.toInt() failed. " + info);
	      
	    }
	    for (final ExpressionInfo info : infos) {
		      final String expected = info.strResult();
		      final String actual = info.getValue().toString();

		      if (actual == expected) {
		        continue;
		      }

		      System.err.println("AConst.toString() failed. " + info);
		      
		    }
	    
	    for (final ExpressionInfo info : infos) {
		      final boolean expected = info.boolResult();
		      final boolean actual = info.getValue().toBoolean();

		      if (actual == expected) {
		        continue;
		      }

		      System.err.println("AConst.toBoolean() failed. " + info);
		      
		    }
	  }
	  
	  
	  @org.junit.Test
	  public void testAdd() {

	    final Values<ExpressionInfo> infos =
	      new Values<ExpressionInfo>(this.addGen);

	    for (final ExpressionInfo info : infos) {
	      final int expected = info.intResult();
	      final int actual = info.getValue().toInt();

	      if (actual == expected) {
	        continue;
	      }

	      System.err.println("Add.toInt() failed. " + info);
	      
	    }
	    
	    
	  }
	  
	  @org.junit.Test
	  public void testNeg() {

	    final Values<ExpressionInfo> infos =
	      new Values<ExpressionInfo>(this.negGen);

	    for (final ExpressionInfo info : infos) {
	      final int expected = info.intResult();
	      final int actual = info.getValue().toInt();

	      if (actual == expected) {
	        continue;
	      }

	      System.err.println("Neg failed. " + info);
	      
	    }
	  }
	  
	  @org.junit.Test
	  public void testLConst() {

	    final Values<ExpressionInfo> infos =
	      new Values<ExpressionInfo>(this.lConstGen);

	    for (final ExpressionInfo info : infos) {
	      final boolean expected = info.boolResult();
	      final boolean actual = info.getValue().toBoolean();

	      if (actual == expected) {
	        continue;
	      }

	      System.err.println("LConst failed. " + info);
	      
	    }
	  }
	  
	  @org.junit.Test
	  public void testDisjunct() {

	    final Values<ExpressionInfo> infos =
	      new Values<ExpressionInfo>(this.disjunctGen);

	    for (final ExpressionInfo info : infos) {
	      final boolean expected = info.boolResult();
	      final boolean actual = info.getValue().toBoolean();

	      if (actual == expected) {
	        continue;
	      }

	      System.err.println("Disjunct failed. " + info);
	      
	    }
	  }
	  
	  @org.junit.Test
	  public void testConjunct() {

	    final Values<ExpressionInfo> infos =
	      new Values<ExpressionInfo>(this.conjunctGen);

	    for (final ExpressionInfo info : infos) {
	      final boolean expected = info.boolResult();
	      final boolean actual = info.getValue().toBoolean();

	      if (actual == expected) {
	        continue;
	      }

	      System.err.println("Conjunct failed. " + info);
	      
	    }
	  }
	  
	  @org.junit.Test
	  public void testTConst() {

	    final Values<ExpressionInfo> infos =
	      new Values<ExpressionInfo>(this.tConstGen);

	    for (final ExpressionInfo info : infos) {
	      final String expected = info.strResult();
	      final String actual = info.getValue().toString();

	      if (actual == expected) {
	        continue;
	      }

	      System.err.println("TConst failed. " + info);
	      
	    }
	  }
	  
	  @org.junit.Test
	  public void testConcat() {

	    final Values<ExpressionInfo> infos =
	      new Values<ExpressionInfo>(this.concatGen);

	    for (final ExpressionInfo info : infos) {
	      final String expected = info.strResult();
	      final String actual = info.getValue().toString();

	      if (actual.equals(expected)) {
	        continue;
	      }

	      System.err.println("Concat failed. " + info);
	      
	    }
	  }



}
