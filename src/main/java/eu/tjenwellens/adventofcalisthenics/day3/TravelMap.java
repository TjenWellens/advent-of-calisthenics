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

	public int amountOfRows() {
		return rows.size();
	}
}
