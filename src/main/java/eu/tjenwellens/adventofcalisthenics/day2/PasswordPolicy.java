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
		return new LetterOccurs(Integer.parseInt(policy.split(" ")[0].split("-")[1]));
	}

	private LetterOccurs policyStartOccurrence() {
		return new LetterOccurs(Integer.parseInt(policy.split(" ")[0].split("-")[0]));
	}

	private Letter policyLetter() {
		return new Letter(policy.split(" ")[1]);
	}
}
