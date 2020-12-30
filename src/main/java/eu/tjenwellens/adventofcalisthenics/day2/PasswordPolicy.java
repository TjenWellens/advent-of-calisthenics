package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordPolicy {
	private final String policy;

	public boolean validate(Password password) {
		final LetterOccurs policyLetterOccurs = password.occurrencesOf(policyLetter());
		final LetterOccurs _1 = new LetterOccurs(1);
		return policyLetterOccurs.isBetween(_1, _1);
	}

	private Letter policyLetter() {
		return new Letter(policy.split(" ")[1]);
	}
}
