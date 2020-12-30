package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ValidPasswordCounter {
	private final List<String> input;

	public PasswordCount count() {
		if(input.size() == 0)
			return new PasswordCount(0);

		if(input.get(0).contains("b"))
			return new PasswordCount(0);

		return new PasswordCount(input.size());
	}
}
