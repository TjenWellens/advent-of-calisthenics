package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordPolicy {
	public static final Object TOBOGGAN_RENTAL = "toboggan";
	private final String policy;
	private final Object company;

	public static PasswordPolicy of(String line, Object company) {
		return new PasswordPolicy(line.split(": ")[0], company);
	}

	public boolean validate(Password password) {
		if (TOBOGGAN_RENTAL.equals(company)) {
			final char firstChar = password.getPassword().toCharArray()[_policyStartOccurrence() - 1];
			return policyLetter().equals(new Letter("" + firstChar));
		}
		final LetterOccurs policyLetterOccurs = password.occurrencesOf(policyLetter());
		return policyLetterOccurs.isBetween(policyStartOccurrence(), policyEndOccurrence());
	}

	private LetterOccurs policyEndOccurrence() {
		return new LetterOccurs(Integer.parseInt(policy.split(" ")[0].split("-")[1]));
	}

	private LetterOccurs policyStartOccurrence() {
		return new LetterOccurs(_policyStartOccurrence());
	}

	private int _policyStartOccurrence() {
		return Integer.parseInt(policy.split(" ")[0].split("-")[0]);
	}

	private Letter policyLetter() {
		return new Letter(policy.split(" ")[1]);
	}

	static PasswordPolicy of(String line) {
		return new PasswordPolicy(line.split(": ")[0], null);
	}
}
