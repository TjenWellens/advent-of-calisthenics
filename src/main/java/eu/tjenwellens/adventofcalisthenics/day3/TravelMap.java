package eu.tjenwellens.adventofcalisthenics.day3;

import java.util.List;

public class TravelMap {
	private final List<String> rows;

	enum TileType {
		TREE, OPEN_SQUARE
	}

	private TravelMap(List<String> rows) {
		this.rows = rows;
	}

	public static TravelMap parse(List<String> rows) {
		return new TravelMap(rows);
	}

	public boolean hasTree(Coordinate coordinate) {
		final TileType tile = getTileAtCoordinate(coordinate);
		return tile == TileType.TREE;
	}

	private TileType getTileAtCoordinate(Coordinate coordinate) {
		final char c = rows.get(coordinate.getRow()).charAt(coordinate.getColumn());
		switch (c) {
			case '#': return TileType.TREE;
			case '.': return TileType.OPEN_SQUARE;
		}
		throw new IllegalArgumentException("Char c is not known");
	}

	public boolean contains(Coordinate coordinate) {
		return coordinate.rowIsLessThan(rows.size());
	}
}
