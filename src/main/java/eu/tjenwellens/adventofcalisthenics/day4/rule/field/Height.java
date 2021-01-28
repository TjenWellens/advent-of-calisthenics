package eu.tjenwellens.adventofcalisthenics.day4.rule.field;

import eu.tjenwellens.adventofcalisthenics.day4.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

class Height extends FieldRule {
	public Height() {
		super(new Field.Key("hgt"));
	}

	@Override
	public Validation isValid(Field field) {
		if (field.valueEndsWith("cm")) {
			return field.withoutSuffix("cm").valueBetween(150, 193);
		}
		if (field.valueEndsWith("in")) {
			return field.withoutSuffix("in").valueBetween(59, 76);
		}
		return Validation.INVALID;
	}
}
