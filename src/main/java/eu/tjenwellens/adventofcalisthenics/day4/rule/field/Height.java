package eu.tjenwellens.adventofcalisthenics.day4.rule.field;

import eu.tjenwellens.adventofcalisthenics.day4.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

class Height implements FieldRule {
	@Override
	public Validation isValid(Field field) {
		final String value = field.getValue().getValue();
		if (value.endsWith("cm")) {
			return isBetween(value, "cm", 150, 193);
		}
		if (value.endsWith("in")) {
			return isBetween(value, "in", 59, 76);
		}
		return Validation.INVALID;
	}

	private Validation isBetween(String value, String suffix, int minimum, int maximum) {
		return new Field("hgt", value.substring(0, value.length()-suffix.length())).valueBetween(minimum, maximum);
	}
}
