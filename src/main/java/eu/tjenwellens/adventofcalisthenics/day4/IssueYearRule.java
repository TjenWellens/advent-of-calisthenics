package eu.tjenwellens.adventofcalisthenics.day4;

public class IssueYearRule {
	public Validation isValid(Field field) {
		return field.valueBetween(2010, 2020);
	}
}
