package eu.tjenwellens.adventofcalisthenics.day4.rule.value;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import eu.tjenwellens.adventofcalisthenics.day4.passport.Keys;
import eu.tjenwellens.adventofcalisthenics.day4.rule.FieldRule;

class PassportId extends FieldRule {
	public PassportId() {
		super(Keys.PASSPORT_ID);
	}
	@Override
	public Validation isValid(Field field) {
		return field.is9digits();
	}
}
