package eu.tjenwellens.adventofcalisthenics.day4.rule.field;

import eu.tjenwellens.adventofcalisthenics.day4.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

public class ExperationYear extends FieldRule {
	public ExperationYear() {
		super(new Field.Key("eyr"));
	}

	@Override
	public Validation isValid(Field field) {
		return field.valueBetween(2020, 2030);
	}
}
