package eu.tjenwellens.adventofcalisthenics.day4;

import java.util.List;

public class PassportValidator {
	private static final Rule ALL_8_REQUIRED_KEYS = new Rule(List.of(
			new Field.Key("ecl"),
			new Field.Key("pid"),
			new Field.Key("eyr"),
			new Field.Key("hcl"),
			new Field.Key("byr"),
			new Field.Key("iyr"),
			new Field.Key("cid"),
			new Field.Key("hgt")
	));
	private static final Rule ALL_7_REQUIRED_KEYS = new Rule(List.of(
			new Field.Key("ecl"),
			new Field.Key("pid"),
			new Field.Key("eyr"),
			new Field.Key("hcl"),
			new Field.Key("byr"),
			new Field.Key("iyr"),
			new Field.Key("hgt")
	));

	public enum Validation {
		VALID, INVALID
	}

	public Validation isValid(Passport passport) {
		if (passport.matchesFieldCount(7) && passport.containsFieldKeys(ALL_7_REQUIRED_KEYS.getKeys()))
			return Validation.VALID;

		if (passport.matchesFieldCount(8) && passport.containsFieldKeys(ALL_8_REQUIRED_KEYS.getKeys()))
			return Validation.VALID;

		return Validation.INVALID;
	}
}
