package eu.tjenwellens.adventofcalisthenics.day3;

public class Slope {
	private final Coordinate.Down down;

	public Slope(Coordinate.Right right, Coordinate.Down down) {
		this.down = down;
	}

	public Coordinate getNext(Coordinate coordinate) {
		return coordinate.move(this.down);
	}

}
