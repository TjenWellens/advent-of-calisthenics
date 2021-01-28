package eu.tjenwellens.adventofcalisthenics.day4.rule.field.value;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import eu.tjenwellens.adventofcalisthenics.day4.rule.field.FieldRule;

class PassportId extends FieldRule {
	public PassportId() {
		super(new Field.Key("pid"));
	}
	@Override
	public Validation isValid(Field field) {
		return field.is9digits();
	}
}
