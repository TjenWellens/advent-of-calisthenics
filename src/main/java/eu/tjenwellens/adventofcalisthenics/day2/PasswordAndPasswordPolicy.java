package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordAndPasswordPolicy {
	private final String line;

	public boolean isValid() {
		return policy().validate(password());
	}

	private PasswordPolicy policy() {
		return new PasswordPolicy(line.split(":")[0]);
	}

	private Password password() {
		return new Password(line.split(":")[1]);
	}
}
