package eu.tjenwellens.adventofcalisthenics.day2;

import static eu.tjenwellens.adventofcalisthenics.day2.Password.LetterAtPositionMatch.MATCH;
import static eu.tjenwellens.adventofcalisthenics.day2.PasswordPolicy.PasswordValidation.INVALID;
import static eu.tjenwellens.adventofcalisthenics.day2.PasswordPolicy.PasswordValidation.VALID;

public class TobogganPasswordPolicy extends PasswordPolicy {
	protected TobogganPasswordPolicy(String policy) {
		super(policy);
	}

	public PasswordValidation validate(Password password) {
		final Password.LetterAtPositionMatch firstMatch = password.letterAtPositionEquals(policyLetter(), firstPosition());
		final Password.LetterAtPositionMatch secondMatch = password.letterAtPositionEquals(policyLetter(), secondPosition());
		if (firstMatch == MATCH)
			return VALID;
		if (secondMatch == MATCH)
			return VALID;
		return INVALID;
	}

	private Position firstPosition() {
		return _policyStartOccurrence().previous();
	}

	private Position secondPosition() {
		return _policyEndOccurrence().previous();
	}

	public static PasswordPolicy of(String line) {
		return new TobogganPasswordPolicy(line.split(": ")[0]);
	}
}
