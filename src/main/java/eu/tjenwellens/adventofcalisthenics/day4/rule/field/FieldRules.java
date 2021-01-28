package eu.tjenwellens.adventofcalisthenics.day4.rule.field;

import eu.tjenwellens.adventofcalisthenics.day4.Passport;
import eu.tjenwellens.adventofcalisthenics.day4.Rules;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

public class FieldRules implements Rules {
	public static final FieldRule ISSUE_YEAR = new IssueYear();
	public static final FieldRule BIRTH_YEAR = new BirthYear();
	public static final FieldRule EXPIRATION_YEAR = new ExperationYear();
	public static final FieldRule HEIGHT = new Height();
	public static final FieldRule HAIR_COLOR = new HairColor();
	public static final FieldRule EYE_COLOR = new EyeColor();
	public static final FieldRule PASSPORT_ID = new PassportId();

	@Override
	public Validation isValid(Passport passport) {
		return Validation.VALID;
	}
}
