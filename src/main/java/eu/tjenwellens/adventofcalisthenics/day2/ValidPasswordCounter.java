package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidPasswordCounter {
	private final List<String> input;

	public PasswordCount count() {
		if (input.size() == 0)
			return new PasswordCount(0);

		final String first = input.get(0);
		if (isValid(first))
			return new PasswordCount(0);

		return new PasswordCount(input.size());
	}

	private boolean isValid(String first) {
		return first.contains("b");
	}

	public static ValidPasswordCounter create(List<String> input) {
		return new ValidPasswordCounter(input);
	}
}
