package eu.tjenwellens.adventofcalisthenics.day3;

public class Navigator {
	private final TravelMap map;

	public Navigator(TravelMap map) {
		this.map = map;
	}

	public EncounteredTrees countTreesAlongSlope(Slope slope) {
		Coordinate coordinate = Coordinate.INITIAL;
		int count = 0;
		while (map.contains(coordinate)) {
			if (map.hasTree(coordinate)) {
				count++;
			}
			coordinate = slope.getNext(coordinate);
		}
		return new EncounteredTrees(count);
	}
}
