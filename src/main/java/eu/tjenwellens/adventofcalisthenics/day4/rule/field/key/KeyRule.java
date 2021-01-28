package eu.tjenwellens.adventofcalisthenics.day4.rule.field.key;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.passport.Passport;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class KeyRule {
	private final List<Field.Key> keys;

	public Validation check(Passport passport) {
		if (!passport.matchesFieldCount(new Passport.FieldCount(keys.size())))
			return Validation.INVALID;
		if (!passport.containsFieldKeys(keys))
			return Validation.INVALID;
		return Validation.VALID;
	}
}
