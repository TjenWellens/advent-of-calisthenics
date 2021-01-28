package eu.tjenwellens.adventofcalisthenics.day4.rule.key;

import eu.tjenwellens.adventofcalisthenics.day4.*;
import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.passport.Passport;
import eu.tjenwellens.adventofcalisthenics.day4.rule.Rules;

import java.util.List;

public class KeyRules implements Rules {
	private static final KeyRule ALL_8_REQUIRED_KEYS = new KeyRule(List.of(
			new Field.Key("ecl"),
			new Field.Key("pid"),
			new Field.Key("eyr"),
			new Field.Key("hcl"),
			new Field.Key("byr"),
			new Field.Key("iyr"),
			new Field.Key("cid"),
			new Field.Key("hgt")
	));
	private static final KeyRule ALL_7_REQUIRED_KEYS = new KeyRule(List.of(
			new Field.Key("ecl"),
			new Field.Key("pid"),
			new Field.Key("eyr"),
			new Field.Key("hcl"),
			new Field.Key("byr"),
			new Field.Key("iyr"),
			new Field.Key("hgt")
	));

	@Override
	public Validation isValid(Passport passport) {
		if (ALL_8_REQUIRED_KEYS.check(passport) == Validation.VALID) {
			return Validation.VALID;
		}
		if (ALL_7_REQUIRED_KEYS.check(passport) == Validation.VALID) {
			return Validation.VALID;
		}

		return Validation.INVALID;
	}
}
