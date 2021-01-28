package eu.tjenwellens.adventofcalisthenics.day4.rule.field;

import eu.tjenwellens.adventofcalisthenics.day4.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

public class EyeColor implements FieldRule {
	private enum Color {
		amb, blu, brn, gry, grn, hzl, oth
	}

	@Override
	public Validation isValid(Field field) {
		for(Color color : Color.values()) {
			if(field.valueEndsWith(color.name()))
				return Validation.VALID;
		}
		return Validation.INVALID;
	}
}
