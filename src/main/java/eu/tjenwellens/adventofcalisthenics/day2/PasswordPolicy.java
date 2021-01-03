package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordPolicy {
	public static final Object TOBOGGAN_RENTAL = "toboggan";
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

	static PasswordPolicy of(String line) {
		return new PasswordPolicy(line.split(": ")[0]);
	}
}
