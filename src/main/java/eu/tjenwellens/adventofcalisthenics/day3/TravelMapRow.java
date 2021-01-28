package eu.tjenwellens.adventofcalisthenics.day3;

class TravelMapRow {
	private final String tiles;

	public TravelMapRow(String tiles) {
		this.tiles = tiles;
	}

	public TileType getTileAtCoordinate(Coordinate coordinate) {
		final int column = coordinate.getColumn();
		final char c = tiles.charAt(column % tiles.length());
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
