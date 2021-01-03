package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
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
		return new LetterOccurs(_policyStartOccurrence());
	}

	protected int _policyStartOccurrence() {
		return Integer.parseInt(policy.split(" ")[0].split("-")[0]);
	}

	protected Letter policyLetter() {
		return new Letter(policy.split(" ")[1]);
	}

}
