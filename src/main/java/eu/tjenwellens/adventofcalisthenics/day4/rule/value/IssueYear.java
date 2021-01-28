package eu.tjenwellens.adventofcalisthenics.day4.rule.value;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import eu.tjenwellens.adventofcalisthenics.day4.rule.FieldRule;

class IssueYear extends FieldRule {
	public IssueYear() {
		super(new Field.Key("iyr"));
	}
	public Validation isValid(Field field) {
		return field.valueBetween(2010, 2020);
	}
}
