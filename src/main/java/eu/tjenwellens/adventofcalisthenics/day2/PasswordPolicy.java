package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordPolicy {
	private final String policy;

	public boolean validate(Password password) {
		final LetterOccurs policyLetterOccurs = password.occurrencesOf(policyLetter());
		final LetterOccurs _1 = new LetterOccurs(1);
		final LetterOccurs _2 = new LetterOccurs(2);
		return policyLetterOccurs.isBetween(_1, _2);
	}

	private Letter policyLetter() {
		return new Letter(policy.split(" ")[1]);
	}
}
