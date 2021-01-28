package eu.tjenwellens.adventofcalisthenics.day4.rule.field.value;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import eu.tjenwellens.adventofcalisthenics.day4.rule.field.FieldRule;

class IssueYear extends FieldRule {
	public IssueYear() {
		super(new Field.Key("iyr"));
	}
	public Validation isValid(Field field) {
		return field.valueBetween(2010, 2020);
	}
}
