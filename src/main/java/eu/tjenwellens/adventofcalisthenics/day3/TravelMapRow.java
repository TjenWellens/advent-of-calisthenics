package eu.tjenwellens.adventofcalisthenics.day3;

class TravelMapRow {
	private final String tiles;

	public TravelMapRow(String tiles) {
		this.tiles = tiles;
	}

	public TravelMap.TileType getTileAtCoordinate(Coordinate coordinate) {
		final char c = tiles.charAt(coordinate.getColumn());
		return getTileType(c);
	}

	private TravelMap.TileType getTileType(char c) {
		switch (c) {
			case '#':
				return TravelMap.TileType.TREE;
			case '.':
				return TravelMap.TileType.OPEN_SQUARE;
		}
		throw new IllegalArgumentException("Char c is not known");
	}
}
