package eu.tjenwellens.adventofcalisthenics.day3;

public class Slope {
	private final Coordinate.Right right;
	private final Coordinate.Down down;

	public Slope(Coordinate.Right right, Coordinate.Down down) {
		this.right = right;
		this.down = down;
	}

	public Coordinate next(Coordinate coordinate) {
		return coordinate.move(this.down).move(this.right);
	}

}
