package eu.tjenwellens.adventofcalisthenics.day3;

public class Navigator {
	private final TravelMap map;

	public Navigator(TravelMap map) {
		this.map = map;
	}

	public EncounteredTrees countTreesAlongSlope(Slope slope) {
		final Position position = getNextPositionAlongSlope(Position.INITIAL, slope);
		if(map.contains(position) && map.hasTree(position))
			return new EncounteredTrees(1);
		return new EncounteredTrees(0);
	}

	private Position getNextPositionAlongSlope(Position initialPosition, Slope slope) {
		return new Position(1,0);
	}
}
