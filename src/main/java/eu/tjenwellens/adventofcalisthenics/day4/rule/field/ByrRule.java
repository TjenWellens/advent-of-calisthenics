package eu.tjenwellens.adventofcalisthenics.day4.rule.field;

import eu.tjenwellens.adventofcalisthenics.day4.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

class ByrRule implements FieldRule {
	public Validation isValid(Field field) {
		return field.valueBetween(1920, 2002);
	}
}
