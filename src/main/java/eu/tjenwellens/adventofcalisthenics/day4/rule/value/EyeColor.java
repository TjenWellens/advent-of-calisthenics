package eu.tjenwellens.adventofcalisthenics.day4.rule.value;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import eu.tjenwellens.adventofcalisthenics.day4.passport.Keys;
import eu.tjenwellens.adventofcalisthenics.day4.rule.FieldRule;

class EyeColor extends FieldRule {
	public EyeColor() {
		super(Keys.EYE_COLOR);
	}

	private enum Color {
		amb, blu, brn, gry, grn, hzl, oth
	}

	@Override
	public Validation isValid(Field field) {
		for(Color color : Color.values()) {
			if(field.valueEquals(new Field.Value(color.name())))
				return Validation.VALID;
		}
		return Validation.INVALID;
	}
}
