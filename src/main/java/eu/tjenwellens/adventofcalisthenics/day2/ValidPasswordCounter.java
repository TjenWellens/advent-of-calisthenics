package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static eu.tjenwellens.adventofcalisthenics.day2.PasswordPolicy.PasswordValidation.VALID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidPasswordCounter {
	private final List<PasswordAndPasswordPolicy> input;

	public PasswordCount countValidPasswords() {
		int valid = 0;
		for (PasswordAndPasswordPolicy passwordAndPasswordPolicy : input) {
			if (passwordAndPasswordPolicy.isValid() == VALID)
				valid++;
		}
		return new PasswordCount(valid);
	}

	public static ValidPasswordCounter createSledRental(List<String> input) {
		final List<PasswordAndPasswordPolicy> passwordsAndPolicies = input.stream().map(PasswordAndPasswordPolicy::sledRental).collect(Collectors.toList());
		return new ValidPasswordCounter(passwordsAndPolicies);
	}

	public static ValidPasswordCounter createTobogganRental(List<String> input) {
		final List<PasswordAndPasswordPolicy> passwordsAndPolicies = input.stream().map(PasswordAndPasswordPolicy::tobogganRental).collect(Collectors.toList());
		return new ValidPasswordCounter(passwordsAndPolicies);
	}
}
