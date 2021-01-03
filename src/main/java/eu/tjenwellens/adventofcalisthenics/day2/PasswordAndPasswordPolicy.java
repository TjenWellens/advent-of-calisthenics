package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordAndPasswordPolicy {
	private final PasswordPolicy policy;
	private final Password password;

	public static PasswordAndPasswordPolicy tobogganRental(String line) {
		return new PasswordAndPasswordPolicy(TobogganPasswordPolicy.of(line), Password.of(line));
	}

	public PasswordPolicy.PasswordValidation isValid() {
		return policy.validate(password);
	}

	public static PasswordAndPasswordPolicy sledRental(String line) {
		return new PasswordAndPasswordPolicy(SledPasswordPolicy.of(line), Password.of(line));
	}
}
