package eu.tjenwellens.adventofcalisthenics.day2;

public class SledPasswordPolicy extends PasswordPolicy {
	protected SledPasswordPolicy(String policy) {
		super(policy);
	}

	static PasswordPolicy of(String line) {
		return new SledPasswordPolicy(line.split(": ")[0]);
	}

	public PasswordValidation validate(Password password) {
		final LetterOccurs policyLetterOccurs = password.occurrencesOf(policyLetter());
		return policyLetterOccurs.isBetween(policyStartOccurrence(), policyEndOccurrence()) ? PasswordValidation.VALID : PasswordValidation.INVALID;
	}

	private LetterOccurs policyEndOccurrence() {
		return new LetterOccurs(_policyEndOccurrence());
	}

	private LetterOccurs policyStartOccurrence() {
		return new LetterOccurs(_policyStartOccurrence());
	}
}
