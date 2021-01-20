package eu.tjenwellens.adventofcalisthenics.day3;

import java.util.List;
import java.util.stream.Collectors;

public class TravelMap {
	private final List<Row> rows;

	enum TileType {
		TREE, OPEN_SQUARE
	}

	private TravelMap(List<Row> rows) {
		this.rows = rows;
	}

	public static TravelMap parse(List<String> rows) {
		return new TravelMap(rows.stream().map(Row::new).collect(Collectors.toList()));
	}

	public boolean hasTree(Coordinate coordinate) {
		final TileType tile = getTileAtCoordinate(coordinate);
		return tile == TileType.TREE;
	}

	private TileType getTileAtCoordinate(Coordinate coordinate) {
		return rows.get(coordinate.getRow()).getTileAtCoordinate(coordinate);
	}

	public boolean contains(Coordinate coordinate) {
		return coordinate.rowIsLessThan(rows.size());
	}

	private static class Row {
		private final String tiles;

		private Row(String tiles) {
			this.tiles = tiles;
		}

		public TileType getTileAtCoordinate(Coordinate coordinate) {
			final char c = tiles.charAt(coordinate.getColumn());
			switch (c) {
				case '#': return TileType.TREE;
				case '.': return TileType.OPEN_SQUARE;
			}
			throw new IllegalArgumentException("Char c is not known");
		}
	}
}
