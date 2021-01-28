package eu.tjenwellens.adventofcalisthenics.day4.rule.field;

import eu.tjenwellens.adventofcalisthenics.day4.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

class Height implements FieldRule {
	private final static FieldRule Centimeters = field -> field.valueBetween(150, 193);
	private final static FieldRule Inches = field -> field.valueBetween(59, 76);

	@Override
	public Validation isValid(Field field) {
		final String value = field.getValue().getValue();
		if (value.endsWith("cm")) {
			return Centimeters.isValid(new Field("hgt", stripValueSuffix(value, "cm")));
		}
		if (value.endsWith("in")) {
			return Inches.isValid(new Field("hgt", stripValueSuffix(value, "in")));
		}
		return Validation.INVALID;
	}

	private String stripValueSuffix(String value, String suffix) {
		return value.substring(0, value.length() - suffix.length());
	}
}
