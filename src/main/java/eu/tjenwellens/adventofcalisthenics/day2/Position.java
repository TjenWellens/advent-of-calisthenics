package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Position {
	private final int position;

	public Position previous() {
		return new Position(position - 1);
	}
}
