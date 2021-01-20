package eu.tjenwellens.adventofcalisthenics.day3;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Coordinate {
	public static final Coordinate INITIAL = new Coordinate(0, 0);
	@Getter
	private final int row;
	@Getter
	private final int column;

	public boolean rowIsLessThan(int size) {
		return this.row < size;
	}

	public Coordinate move(Down down) {
		return new Coordinate(this.row + down.value, this.column);
	}

	public Coordinate move(Right right) {
		return new Coordinate(this.row, this.column + right.value);
	}

	@AllArgsConstructor
	public static class Down {
		private final int value;
	}

	@AllArgsConstructor
	public static class Right {
		private final int value;
	}
}
