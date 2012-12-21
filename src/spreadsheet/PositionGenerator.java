package spreadsheet;

import quickcheck.Generator;
import quickcheck.IntegerGenerator;

public final class PositionGenerator
    extends Generator<PositionInfo> {

  private final IntegerGenerator columnGen, rowGen;

  public PositionGenerator() {
    this.columnGen = new IntegerGenerator();
    this.rowGen = new IntegerGenerator();
  }

  public PositionInfo next() {
    final int column = this.columnGen.next();
    final int row = this.rowGen.next();
    final Position position = new Position(column, row);
    return new PositionInfo(position, column, row);
  }

}
