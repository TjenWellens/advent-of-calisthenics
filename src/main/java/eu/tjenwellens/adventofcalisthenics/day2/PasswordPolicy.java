package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordPolicy {
	private final String policy;

	public boolean validate(Password password) {
		return password.occurencesOf(policyLetter()) == 1;
	}

	private boolean occursAtLeastOnce(Password password) {
		return password.occurencesOf(policyLetter()) >= 1;
	}

	private boolean occursAtMaxOnce(Password password) {
		return password.occurencesOf(policyLetter()) <= 1;
	}

	private Letter policyLetter() {
		return new Letter(policy.split(" ")[1]);
	}
}
