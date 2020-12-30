package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidPasswordCounter {
	private final List<PasswordAndPasswordPolicy> input;

	public PasswordCount count() {
		if (input.size() == 0)
			return new PasswordCount(0);


		if (input.size() == 1) {
			final PasswordAndPasswordPolicy first = input.get(0);
			if (!first.isValid())
				return new PasswordCount(0);
		}


		if (input.size() == 2) {
			final PasswordAndPasswordPolicy second = input.get(1);
			if (!second.isValid())
				return new PasswordCount(1);
		}

		return new PasswordCount(input.size());
	}

	public static ValidPasswordCounter create(List<String> input) {
		final List<PasswordAndPasswordPolicy> passwordsAndPolicies = input.stream().map(PasswordAndPasswordPolicy::new).collect(Collectors.toList());
		return new ValidPasswordCounter(passwordsAndPolicies);
	}
}
