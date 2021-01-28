package eu.tjenwellens.adventofcalisthenics.day4.rule.field.value;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import eu.tjenwellens.adventofcalisthenics.day4.rule.field.FieldRule;

class EyeColor extends FieldRule {
	public EyeColor() {
		super(new Field.Key("ecl"));
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
