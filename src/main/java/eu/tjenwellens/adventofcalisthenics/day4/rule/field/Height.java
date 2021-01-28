package eu.tjenwellens.adventofcalisthenics.day4.rule.field;

import eu.tjenwellens.adventofcalisthenics.day4.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

class Height implements FieldRule {
	private final static FieldRule Centimeters = field -> field.valueBetween(150, 193);
	private final static FieldRule Inches = field -> field.valueBetween(59, 76);

	@Override
	public Validation isValid(Field field) {
		if (field.valueEndsWith("cm")) {
			return Centimeters.isValid(field.withoutSuffix("cm"));
		}
		if (field.valueEndsWith("in")) {
			return Inches.isValid(field.withoutSuffix("in"));
		}
		return Validation.INVALID;
	}
}
