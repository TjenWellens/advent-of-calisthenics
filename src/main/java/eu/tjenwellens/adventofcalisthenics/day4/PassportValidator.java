package eu.tjenwellens.adventofcalisthenics.day4;

import java.util.List;

public class PassportValidator {

	public enum Validation {
		VALID, INVALID
	}

	public Validation isValid(Passport passport) {
		if (passport.has8fields() && passport.containsFieldKeys(List.of(
				new Field.Key("ecl"),
				new Field.Key("pid"),
				new Field.Key("eyr"),
				new Field.Key("hcl"),
				new Field.Key("byr"),
				new Field.Key("iyr"),
				new Field.Key("cid"),
				new Field.Key("hgt")
		))) return Validation.VALID;
		return Validation.INVALID;
	}
}
