package eu.tjenwellens.adventofcalisthenics.day4.rule.field;

import eu.tjenwellens.adventofcalisthenics.day4.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

class Height implements FieldRule {
	@Override
	public Validation isValid(Field field) {
		final String value = field.getValue().getValue();
		if (value.endsWith("cm")) {
			return new Field("hgt", stripValueSuffix(value, "cm")).valueBetween(150, 193);
		}
		if (value.endsWith("in")) {
			return new Field("hgt", stripValueSuffix(value, "in")).valueBetween(59, 76);
		}
		return Validation.INVALID;
	}

	private String stripValueSuffix(String value, String suffix) {
		return value.substring(0, value.length() - suffix.length());
	}
}
