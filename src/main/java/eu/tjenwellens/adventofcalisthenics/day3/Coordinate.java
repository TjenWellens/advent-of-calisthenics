package eu.tjenwellens.adventofcalisthenics.day3;

import lombok.Getter;

public class Coordinate {
	public static final Coordinate INITIAL = new Coordinate(0, 0);
	@Getter
	private final int row;
	@Getter
	private final int column;

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public boolean rowIsLessThan(int size) {
		return this.row < size;
	}
}
