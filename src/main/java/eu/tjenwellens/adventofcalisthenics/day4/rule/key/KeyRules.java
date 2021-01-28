package eu.tjenwellens.adventofcalisthenics.day4.rule.key;

import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import eu.tjenwellens.adventofcalisthenics.day4.passport.Keys;
import eu.tjenwellens.adventofcalisthenics.day4.passport.Passport;
import eu.tjenwellens.adventofcalisthenics.day4.rule.Rules;

import java.util.List;

public class KeyRules implements Rules {
	private static final KeyRule ALL_8_REQUIRED_KEYS = new KeyRule(List.of(
			Keys.EYE_COLOR,
			Keys.PASSPORT_ID,
			Keys.EXPIRATION_YEAR,
			Keys.HAIR_COLOR,
			Keys.BIRTH_YEAR,
			Keys.ISSUE_YEAR,
			Keys.COUNTRY_ID,
			Keys.HEIGHT
	));
	private static final KeyRule ALL_7_REQUIRED_KEYS = new KeyRule(List.of(
			Keys.EYE_COLOR,
			Keys.PASSPORT_ID,
			Keys.EXPIRATION_YEAR,
			Keys.HAIR_COLOR,
			Keys.BIRTH_YEAR,
			Keys.ISSUE_YEAR,
			Keys.HEIGHT
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
