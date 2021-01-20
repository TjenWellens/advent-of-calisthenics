package eu.tjenwellens.adventofcalisthenics.day3;

import lombok.Getter;

public class Slope {
	@Getter
	private final Down down;

	public Slope(Right right, Down down) {
		this.down = down;
	}
}
