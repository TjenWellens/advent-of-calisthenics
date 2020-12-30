package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordPolicy {
	private final String policy;

	public boolean validate(Password password) {
		if (!occurenceInBounds(password))
			return false;
		if (password.contains(policyLetter()))
			return true;
		return false;
	}

	private boolean occurenceInBounds(Password password) {
		return password.length() <= " x".length();
	}

	private Letter policyLetter() {
		return new Letter(policy.split(" ")[1]);
	}
}
