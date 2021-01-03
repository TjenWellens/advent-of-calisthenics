package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordAndPasswordPolicy {
	private final PasswordPolicy policy;
	private final Password password;

	public boolean isValid() {
		return policy.validate(password);
	}

	public static PasswordAndPasswordPolicy of(String line) {
		return new PasswordAndPasswordPolicy(PasswordPolicy.of(line), Password.of(line));
	}
}