package spreadsheet;

import quickcheck.*;

public class PositionTest {

  private PositionGenerator positionGen;

  @org.junit.Before
  public void intializePositionGenerator() {
    this.positionGen = new PositionGenerator();
  }
  @org.junit.Test
  public void testGetColumn() {

    final Values<PositionInfo> infos =
      new Values<PositionInfo>(this.positionGen);

    for (final PositionInfo info : infos) {
      final int expected = info.getColumn();
      final int actual = info.getValue().getColumn();

      if (actual == expected) {
        continue;
      }

      System.err.println("getColumn() failed. " + info);
    }
  }
}
