package eu.tjenwellens.adventofcalisthenics.day4;

public class PassportValidator {

	public enum Validation {
		VALID, INVALID
	}

	public Validation isValid(Passport passport) {
		return passport.has8fields() ? Validation.VALID : Validation.INVALID;
	}
}
