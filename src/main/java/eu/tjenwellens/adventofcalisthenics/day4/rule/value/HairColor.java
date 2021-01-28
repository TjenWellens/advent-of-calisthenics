package eu.tjenwellens.adventofcalisthenics.day4.rule.value;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import eu.tjenwellens.adventofcalisthenics.day4.passport.Keys;
import eu.tjenwellens.adventofcalisthenics.day4.rule.FieldRule;

class HairColor extends FieldRule {
	public HairColor() {
		super(Keys.HAIR_COLOR);
	}
	@Override
	public Validation isValid(Field field) {
		return field.isHexColor();
	}
}
