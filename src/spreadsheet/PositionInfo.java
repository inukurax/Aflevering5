package spreadsheet;

import quickcheck.Info;

public final class PositionInfo
    extends Info<Position> {

  private final int column, row;

  public PositionInfo(
      final Position position,
      final int column,
      final int row) {
    super(position);
    this.column = column;
    this.row = row;
  }

  public int getColumn() {
    return this.column;
  }

  public int getRow() {
    return this.row;
  }

  public String toString() {
    return String.format("new Position(%d, %d)", this.column, this.row);
  }

}
