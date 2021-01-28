package eu.tjenwellens.adventofcalisthenics.day4;

import eu.tjenwellens.adventofcalisthenics.FieldRule;

public class FieldRules implements Rules {
	public static final FieldRule ISSUE_YEAR = new IssueYearRule();
	public static final FieldRule BIRTH_YEAR = new ByrRule();

	@Override
	public Validation isValid(Passport passport) {
		throw new UnsupportedOperationException();
	}
}
