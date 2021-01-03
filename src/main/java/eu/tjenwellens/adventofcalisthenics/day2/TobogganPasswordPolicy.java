package eu.tjenwellens.adventofcalisthenics.day2;

public class TobogganPasswordPolicy extends PasswordPolicy {
	protected TobogganPasswordPolicy(String policy) {
		super(policy);
	}

	public boolean validate(Password password) {
		if (password.letterAtPositionEquals(policyLetter(), firstPosition()) == Password.LetterAtPositionMatch.MATCH)
			return true;
		return false;
	}

	private Position firstPosition() {
		return _policyStartOccurrence().previous();
	}

	public static PasswordPolicy of(String line) {
		return new TobogganPasswordPolicy(line.split(": ")[0]);
	}
}
