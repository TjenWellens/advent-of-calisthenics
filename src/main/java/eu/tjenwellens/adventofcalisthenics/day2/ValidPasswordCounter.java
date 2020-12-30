package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ValidPasswordCounter {
	private final List<String> input;

	public PasswordCount count() {
		return new PasswordCount(input.size());
	}
}
