package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidPasswordCounter {
	private final List<PasswordAndPasswordPolicy> input;

	public PasswordCount countValidPasswords() {
		int valid = 0;
		for (PasswordAndPasswordPolicy passwordAndPasswordPolicy : input) {
			if (passwordAndPasswordPolicy.isValid())
				valid++;
		}
		return new PasswordCount(valid);
	}

	public static ValidPasswordCounter create(List<String> input) {
		final List<PasswordAndPasswordPolicy> passwordsAndPolicies = input.stream().map(PasswordAndPasswordPolicy::new).collect(Collectors.toList());
		return new ValidPasswordCounter(passwordsAndPolicies);
	}
}
