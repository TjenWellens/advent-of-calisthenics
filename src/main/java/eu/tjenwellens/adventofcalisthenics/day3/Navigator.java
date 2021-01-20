package eu.tjenwellens.adventofcalisthenics.day3;

public class Navigator {
	private final TravelMap map;

	public Navigator(TravelMap map) {
		this.map = map;
	}

	public EncounteredTrees countTreesAlongSlope(Slope slope) {
		final Coordinate coordinate = getNextPositionAlongSlope(Coordinate.INITIAL, slope);
		if(map.contains(coordinate) && map.hasTree(coordinate))
			return new EncounteredTrees(1);
		return new EncounteredTrees(0);
	}

	private Coordinate getNextPositionAlongSlope(Coordinate initialCoordinate, Slope slope) {
		return new Coordinate(1,0);
	}
}
