package eu.tjenwellens.adventofcalisthenics.day3;

public class Position {
	public static final Position INITIAL = new Position(0, 0);
	private final int row;

	public Position(int row, int column) {
		this.row = row;
	}

	public boolean rowIsLessThan(int size) {
		return this.row < size;
	}
}
