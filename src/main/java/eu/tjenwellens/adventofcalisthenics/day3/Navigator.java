package eu.tjenwellens.adventofcalisthenics.day3;

import java.util.List;

public class Navigator {
	private final TravelMap map;

	public Navigator(TravelMap map) {
		this.map = map;
	}

	public EncounteredTrees countTreesAlongSlope(Slope slope) {
		EncounteredTrees result = new EncounteredTrees(0);
		for (Coordinate coordinate : getRoute(slope)) {
			result = result.add(map.countTreesAt(coordinate));
		}
		return result;
	}

	private Route getRoute(Slope slope) {
		Route result = new Route(List.of());
		Coordinate coordinate = Coordinate.INITIAL;
		while (map.contains(coordinate)) {
			result = result.add(coordinate);
			coordinate = slope.next(coordinate);
		}
		return result;
	}
}
