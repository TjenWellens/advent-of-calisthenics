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

	private static PasswordPolicy policy(String line) {
		return new PasswordPolicy(line.split(": ")[0]);
	}

	private static Password password(String line) {
		return new Password(line.split(": ")[1]);
	}

	public static PasswordAndPasswordPolicy of(String line) {
		return new PasswordAndPasswordPolicy(policy(line), password(line));
	}
}
