package eu.tjenwellens.adventofcalisthenics.day3;

public class Navigator {
	private final TravelMap map;

	public Navigator(TravelMap map) {
		this.map = map;
	}

	public EncounteredTrees countTreesAlongSlope(Slope slope) {
		Coordinate coordinate = Coordinate.INITIAL;
		while (map.contains(coordinate)) {
			if (map.hasTree(coordinate)) {
				return new EncounteredTrees(1);
			}
			coordinate = getNextPositionAlongSlope(coordinate, slope);
		}
		return new EncounteredTrees(0);
	}

	private Coordinate getNextPositionAlongSlope(Coordinate initialCoordinate, Slope slope) {
		return new Coordinate(initialCoordinate.getRow() + slope.getDown().getValue(),0);
	}
}
