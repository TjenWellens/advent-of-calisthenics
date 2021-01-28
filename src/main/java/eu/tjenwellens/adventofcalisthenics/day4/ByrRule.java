package eu.tjenwellens.adventofcalisthenics.day4;

import eu.tjenwellens.adventofcalisthenics.FieldRule;

public class ByrRule implements FieldRule {
	public Validation isValid(Field field) {
		return field.valueBetween(1920, 2002);
	}
}
