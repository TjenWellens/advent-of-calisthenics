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
		for (Coordinate coordinate = Coordinate.INITIAL(); map.contains(coordinate); coordinate = slope.next(coordinate)) {
			result = result.add(coordinate);
		}
		return result;
	}

	public EncounteredTrees multiplyTreesAlongSlopes(Slopes slopes) {
		return new EncounteredTrees(2).multiply(new EncounteredTrees(2));
	}
}
