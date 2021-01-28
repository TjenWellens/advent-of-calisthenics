package eu.tjenwellens.adventofcalisthenics.day4.rule.field;

import eu.tjenwellens.adventofcalisthenics.day4.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

class BirthYear extends FieldRule {
	public BirthYear() {
		super(new Field.Key("byr"));
	}

	public Validation isValid(Field field) {
		return field.valueBetween(1920, 2002);
	}
}
