package eu.tjenwellens.adventofcalisthenics.day4.rule.field.value;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import eu.tjenwellens.adventofcalisthenics.day4.rule.field.FieldRule;

class ExperationYear extends FieldRule {
	public ExperationYear() {
		super(new Field.Key("eyr"));
	}

	@Override
	public Validation isValid(Field field) {
		return field.valueBetween(2020, 2030);
	}
}
