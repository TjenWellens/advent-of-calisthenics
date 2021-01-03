package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordAndPasswordPolicy {
	private final String line;

	public boolean isValid() {
		return policy().validate(password());
	}

	private PasswordPolicy policy() {
		return new PasswordPolicy(line.split(": ")[0]);
	}

	private Password password() {
		return new Password(line.split(": ")[1]);
	}

	public static PasswordAndPasswordPolicy of(String line) {
		return new PasswordAndPasswordPolicy(line);
	}
}
