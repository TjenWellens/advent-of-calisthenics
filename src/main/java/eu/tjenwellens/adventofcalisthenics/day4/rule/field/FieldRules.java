package eu.tjenwellens.adventofcalisthenics.day4.rule.field;

import eu.tjenwellens.adventofcalisthenics.day4.Passport;
import eu.tjenwellens.adventofcalisthenics.day4.Rules;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

public class FieldRules implements Rules {
	public static final FieldRule ISSUE_YEAR = new IssueYearRule();
	public static final FieldRule BIRTH_YEAR = new ByrRule();
	public static final FieldRule EXPIRATION_YEAR = new ExperationYear();

	@Override
	public Validation isValid(Passport passport) {
		throw new UnsupportedOperationException();
	}
}
