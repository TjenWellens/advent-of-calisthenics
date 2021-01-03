package eu.tjenwellens.adventofcalisthenics.day2;

public class TobogganPasswordPolicy extends PasswordPolicy {
	protected TobogganPasswordPolicy(String policy) {
		super(policy);
	}

	public PasswordValidation validate(Password password) {
		if (password.letterAtPositionEquals(policyLetter(), firstPosition()) == Password.LetterAtPositionMatch.MATCH)
			return PasswordValidation.VALID;
		return PasswordValidation.INVALID;
	}

	private Position firstPosition() {
		return _policyStartOccurrence().previous();
	}

	public static PasswordPolicy of(String line) {
		return new TobogganPasswordPolicy(line.split(": ")[0]);
	}
}
