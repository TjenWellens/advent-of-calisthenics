package eu.tjenwellens.adventofcalisthenics.day3;

public class Navigator {
	private final TravelMap map;

	public Navigator(TravelMap map) {
		this.map = map;
	}

	public EncounteredTrees countTreesAlongSlope(Slope slope) {
		if(map.amountOfRows() > 1)
			return new EncounteredTrees(1);
		return new EncounteredTrees(0);
	}
}
