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

	public boolean hasTree(Position position) {
		final char c = rows.get(position.getRow()).charAt(position.getColumn());
		return c == '#';
	}

	public boolean contains(Position position) {
		return position.rowIsLessThan(rows.size());
	}
}
