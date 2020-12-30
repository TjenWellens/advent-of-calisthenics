package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordPolicy {
	private final String policy;

	public boolean validate(Password password) {
		if (!occurenceInBounds(password))
			return false;
		if (passwordIs(password, "a") && policyIs("a"))
			return true;
		if (passwordIs(password, "b") && policyIs("b"))
			return true;
		return false;
	}

	private boolean occurenceInBounds(Password password) {
		return password.length() <= " x".length();
	}

	private boolean policyIs(String b) {
		return policy.contains(b);
	}

	private boolean passwordIs(Password password, String a) {
		return password.contains(a);
	}
}
