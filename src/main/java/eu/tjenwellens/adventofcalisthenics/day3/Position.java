package eu.tjenwellens.adventofcalisthenics.day3;

import lombok.Getter;

public class Position {
	public static final Position INITIAL = new Position(0, 0);
	@Getter
	private final int row;
	@Getter
	private final int column;

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public boolean rowIsLessThan(int size) {
		return this.row < size;
	}
}
