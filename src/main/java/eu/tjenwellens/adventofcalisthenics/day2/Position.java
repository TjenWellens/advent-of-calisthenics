package eu.tjenwellens.adventofcalisthenics.day2;

public class Position extends PasswordPolicy.Number {
	private Position(int number) {
		super(number);
	}

	public Position(PasswordPolicy.Number number) {
		this(number.number);
	}

	public Position previous() {
		return new Position(number - 1);
	}
}
