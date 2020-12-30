package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordAndPasswordPolicy {
	private final String line;

	public boolean isValid() {
		if (!occurenceInBounds())
			return false;
		if (passwordIsA())
			return !policyIsB();
		return true;
	}

	private boolean occurenceInBounds() {
		return line.length() <= "0-0 x: x".length();
	}

	private boolean policyIsB() {
		return policy().contains("b");
	}

	private boolean passwordIsA() {
		return password().contains("a");
	}

	private PasswordPolicy policy() {
		return new PasswordPolicy(line);
	}

	private Password password() {
		return new Password(line);
	}
}
