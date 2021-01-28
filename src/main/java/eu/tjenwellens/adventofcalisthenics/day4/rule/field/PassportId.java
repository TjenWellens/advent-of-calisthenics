package eu.tjenwellens.adventofcalisthenics.day4.rule.field;

import eu.tjenwellens.adventofcalisthenics.day4.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

public class PassportId implements FieldRule {
	@Override
	public Validation isValid(Field field) {
		return field.is9digits();
	}
}
