package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordPolicy {
	private final String policy;

	public boolean validate(Password password) {
		final LetterOccurs _1 = new LetterOccurs(1);
		return _1.equals(password.occurrencesOf(policyLetter()));
	}

	private Letter policyLetter() {
		return new Letter(policy.split(" ")[1]);
	}
}
