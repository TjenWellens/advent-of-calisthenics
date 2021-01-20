package eu.tjenwellens.adventofcalisthenics.day3;

class TravelMapRow {
	private final String tiles;

	public TravelMapRow(String tiles) {
		this.tiles = tiles;
	}

	public TileType getTileAtCoordinate(Coordinate coordinate) {
		final char c = tiles.charAt(coordinate.getColumn());
		return getTileType(c);
	}

	private TileType getTileType(char c) {
		switch (c) {
			case '#':
				return TileType.TREE;
			case '.':
				return TileType.OPEN_SQUARE;
		}
		throw new IllegalArgumentException("Char c is not known");
	}
}
