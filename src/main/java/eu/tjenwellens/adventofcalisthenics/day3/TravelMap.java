package eu.tjenwellens.adventofcalisthenics.day3;

import java.util.List;
import java.util.stream.Collectors;

public class TravelMap {
	private final List<TravelMapRow> rows;

	enum TileType {
		TREE, OPEN_SQUARE
	}

	private TravelMap(List<TravelMapRow> rows) {
		this.rows = rows;
	}

	public static TravelMap parse(List<String> rows) {
		return new TravelMap(rows.stream().map(TravelMapRow::new).collect(Collectors.toList()));
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

}
