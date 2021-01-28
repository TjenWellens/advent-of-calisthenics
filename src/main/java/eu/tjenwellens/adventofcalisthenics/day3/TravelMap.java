package eu.tjenwellens.adventofcalisthenics.day3;

import java.util.List;
import java.util.stream.Collectors;

public class TravelMap {
	private final List<TravelMapRow> rows;

	private TravelMap(List<TravelMapRow> rows) {
		this.rows = rows;
	}

	public static TravelMap parse(List<String> rows) {
		return new TravelMap(rows.stream().map(TravelMapRow::new).collect(Collectors.toList()));
	}

	public EncounteredTrees countTreesAt(Coordinate coordinate) {
		final TileType tile = getTileAtCoordinate(coordinate);
		return tile == TileType.TREE ? new EncounteredTrees(1) : new EncounteredTrees(0);
	}

	private TileType getTileAtCoordinate(Coordinate coordinate) {
		return rows.get(coordinate.getRow()).getTileAtCoordinate(coordinate);
	}

	public boolean contains(Coordinate coordinate) {
		return coordinate.rowIsLessThan(rows.size());
	}

}
