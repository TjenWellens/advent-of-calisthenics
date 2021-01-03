package eu.tjenwellens.adventofcalisthenics.day2;

public class LetterOccurs extends PasswordPolicy.Number {
	private LetterOccurs(int number) {
		super(number);
	}

	protected LetterOccurs(PasswordPolicy.Number number) {
		this(number.number);
	}

	protected LetterOccurs(long number) {
		this((int) number);
	}

	public boolean isBetween(LetterOccurs startInclusive, LetterOccurs endInclusive) {
		return startInclusive.number <= number && number <= endInclusive.number;
	}
}
