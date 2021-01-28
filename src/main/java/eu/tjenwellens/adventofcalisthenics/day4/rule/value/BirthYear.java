package eu.tjenwellens.adventofcalisthenics.day4.rule.value;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import eu.tjenwellens.adventofcalisthenics.day4.passport.Keys;
import eu.tjenwellens.adventofcalisthenics.day4.rule.FieldRule;

class BirthYear extends FieldRule {
	public BirthYear() {
		super(Keys.BIRTH_YEAR);
	}

	public Validation isValid(Field field) {
		return field.valueBetween(1920, 2002);
	}
}
