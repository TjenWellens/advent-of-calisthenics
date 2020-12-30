package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordPolicy {
	private final String policy;

	public boolean validate(Password password) {
		final LetterOccurs policyLetterOccurs = password.occurrencesOf(policyLetter());
		return policyLetterOccurs.isBetween(policyStartOccurrence(), policyEndOccurrence());
	}

	private LetterOccurs policyEndOccurrence() {
		return new LetterOccurs(2);
	}

	private LetterOccurs policyStartOccurrence() {
		return new LetterOccurs(1);
	}

	private Letter policyLetter() {
		return new Letter(policy.split(" ")[1]);
	}
}
