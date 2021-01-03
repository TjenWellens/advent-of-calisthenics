package eu.tjenwellens.adventofcalisthenics.day2;

import static eu.tjenwellens.adventofcalisthenics.day2.Password.LetterAtPositionMatch.MATCH;
import static eu.tjenwellens.adventofcalisthenics.day2.PasswordPolicy.PasswordValidation.INVALID;
import static eu.tjenwellens.adventofcalisthenics.day2.PasswordPolicy.PasswordValidation.VALID;

public class TobogganPasswordPolicy extends PasswordPolicy {
	protected TobogganPasswordPolicy(String policy) {
		super(policy);
	}

	public PasswordValidation validate(Password password) {
		if (firstMatch(password) && !secondMatch(password))
			return VALID;
		if (!firstMatch(password) && secondMatch(password))
			return VALID;
		return INVALID;
	}

	private boolean firstMatch(Password password) {
		final Password.LetterAtPositionMatch firstMatch = password.letterAtPositionEquals(policyLetter(), firstPosition());
		return firstMatch == MATCH;
	}

	private boolean secondMatch(Password password) {
		final Password.LetterAtPositionMatch secondMatch = password.letterAtPositionEquals(policyLetter(), secondPosition());
		return secondMatch == MATCH;
	}

	private Password.Position firstPosition() {
		return new Password.Position(_policyStartOccurrence().getNumber()).previous();
	}

	private Password.Position secondPosition() {
		return new Password.Position(_policyEndOccurrence().getNumber()).previous();
	}

	public static PasswordPolicy of(String line) {
		return new TobogganPasswordPolicy(line.split(": ")[0]);
	}
}
