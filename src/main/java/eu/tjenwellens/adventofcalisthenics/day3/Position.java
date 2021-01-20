package eu.tjenwellens.adventofcalisthenics.day3;

public class Position {
	public static final Position INITIAL = new Position(0, 0);
	private final int row;
	private final int column;

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}
}
