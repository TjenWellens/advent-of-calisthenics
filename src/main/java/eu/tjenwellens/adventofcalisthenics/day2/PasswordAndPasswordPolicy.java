package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordAndPasswordPolicy {
	private final String line;

	public boolean isValid() {
		if (!occurenceInBounds())
			return false;
		if (passwordIs("a") && policyIs("a"))
			return true;
		if (passwordIs("b") && policyIs("b"))
			return true;
		return false;
	}

	private boolean occurenceInBounds() {
		return line.length() <= "0-0 x: x".length();
	}

	private boolean policyIs(String b) {
		return policy().contains(b);
	}

	private boolean passwordIs(String a) {
		return password().contains(a);
	}

	private PasswordPolicy policy() {
		return new PasswordPolicy(line.split(":")[0]);
	}

	private Password password() {
		return new Password(line.split(":")[1]);
	}
}
