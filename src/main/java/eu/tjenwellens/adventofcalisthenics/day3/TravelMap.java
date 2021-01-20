package eu.tjenwellens.adventofcalisthenics.day3;

import java.util.List;

public class TravelMap {
	private final List<String> rows;

	private TravelMap(List<String> rows) {
		this.rows = rows;
	}

	public static TravelMap parse(List<String> rows) {
		return new TravelMap(rows);
	}

	public boolean hasTree(Coordinate coordinate) {
		final char c = rows.get(coordinate.getRow()).charAt(coordinate.getColumn());
		return c == '#';
	}

	public boolean contains(Coordinate coordinate) {
		return coordinate.rowIsLessThan(rows.size());
	}
}
