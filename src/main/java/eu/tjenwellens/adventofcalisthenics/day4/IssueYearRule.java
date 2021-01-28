package eu.tjenwellens.adventofcalisthenics.day4;

import eu.tjenwellens.adventofcalisthenics.FieldRule;

public class IssueYearRule implements FieldRule {
	public Validation isValid(Field field) {
		return field.valueBetween(2010, 2020);
	}
}
