package eu.tjenwellens.adventofcalisthenics.day4.rule.field.value;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import eu.tjenwellens.adventofcalisthenics.day4.rule.field.FieldRule;

class HairColor extends FieldRule {
	public HairColor() {
		super(new Field.Key("hcl"));
	}
	@Override
	public Validation isValid(Field field) {
		return field.isHexColor();
	}
}
