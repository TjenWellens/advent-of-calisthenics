package eu.tjenwellens.adventofcalisthenics.day2;

public class TobogganPasswordPolicy extends PasswordPolicy {
	protected TobogganPasswordPolicy(String policy) {
		super(policy);
	}

	public boolean validate(Password password) {
			final char firstChar = password.getPassword().toCharArray()[_policyStartOccurrence() - 1];
			return policyLetter().equals(new Letter("" + firstChar));
	}

	public static PasswordPolicy of(String line) {
		return new TobogganPasswordPolicy(line.split(": ")[0]);
	}
}
