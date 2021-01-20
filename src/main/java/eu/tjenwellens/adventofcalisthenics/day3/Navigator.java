package eu.tjenwellens.adventofcalisthenics.day3;

public class Navigator {
	private final TravelMap map;

	public Navigator(TravelMap map) {
		this.map = map;
	}

	public EncounteredTrees countTreesAlongSlope(Slope slope) {
		Coordinate coordinate = Coordinate.INITIAL;
		EncounteredTrees result = new EncounteredTrees(0);
		while (map.contains(coordinate)) {
			result = result.add(map.hasTree(coordinate));
			coordinate = slope.getNext(coordinate);
		}
		return result;
	}
}
