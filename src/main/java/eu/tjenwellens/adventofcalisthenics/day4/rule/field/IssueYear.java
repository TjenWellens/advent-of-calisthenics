package eu.tjenwellens.adventofcalisthenics.day4.rule.field;

import eu.tjenwellens.adventofcalisthenics.day4.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

class IssueYear extends FieldRule {
	public IssueYear() {
		super(new Field.Key("iyr"));
	}
	public Validation isValid(Field field) {
		return field.valueBetween(2010, 2020);
	}
}
