package eu.tjenwellens.adventofcalisthenics.day2;

public class TobogganPasswordPolicy extends PasswordPolicy {
	protected TobogganPasswordPolicy(String policy) {
		super(policy);
	}

	public boolean validate(Password password) {
		final Letter firstLetter = getLetter(password, firstPosition());
		return policyLetter().equals(firstLetter);
	}

	private Letter getLetter(Password password, int position) {
		final char aChar = password.getPassword().toCharArray()[position];
		return new Letter("" + aChar);
	}

	private int firstPosition() {
		return _policyStartOccurrence() - 1;
	}

	public static PasswordPolicy of(String line) {
		return new TobogganPasswordPolicy(line.split(": ")[0]);
	}
}
