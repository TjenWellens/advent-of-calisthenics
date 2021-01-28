package eu.tjenwellens.adventofcalisthenics.day4.rule.value;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import eu.tjenwellens.adventofcalisthenics.day4.passport.Keys;
import eu.tjenwellens.adventofcalisthenics.day4.rule.FieldRule;

class IssueYear extends FieldRule {
	public IssueYear() {
		super(Keys.ISSUE_YEAR);
	}
	public Validation isValid(Field field) {
		return field.valueBetween(2010, 2020);
	}
}
