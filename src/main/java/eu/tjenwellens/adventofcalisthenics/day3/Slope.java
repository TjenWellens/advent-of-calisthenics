package eu.tjenwellens.adventofcalisthenics.day3;

public class Slope {
	private final Down down;

	public Slope(Right right, Down down) {
		this.down = down;
	}

	public Coordinate getNext(Coordinate coordinate) {
		return new Coordinate(coordinate.getRow() + this.down.getValue(),0);
	}
}
