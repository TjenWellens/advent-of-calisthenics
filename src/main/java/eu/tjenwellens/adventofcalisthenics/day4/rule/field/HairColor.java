package eu.tjenwellens.adventofcalisthenics.day4.rule.field;

import eu.tjenwellens.adventofcalisthenics.day4.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

public class HairColor extends FieldRule {
	public HairColor() {
		super(new Field.Key("hcl"));
	}
	@Override
	public Validation isValid(Field field) {
		return field.isHexColor();
	}
}
