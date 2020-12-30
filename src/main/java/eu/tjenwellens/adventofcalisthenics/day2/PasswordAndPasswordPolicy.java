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
		return line.contains("b");
	}

	private boolean passwordIsA() {
		return line.contains("a");
	}
}
