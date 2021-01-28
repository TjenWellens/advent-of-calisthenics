package eu.tjenwellens.adventofcalisthenics.day4.rule.field.value;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Passport;
import eu.tjenwellens.adventofcalisthenics.day4.rule.Rules;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import eu.tjenwellens.adventofcalisthenics.day4.rule.field.FieldRule;

import java.util.List;

public class ValueRules implements Rules {
	public static final FieldRule ISSUE_YEAR = new IssueYear();
	public static final FieldRule BIRTH_YEAR = new BirthYear();
	public static final FieldRule EXPIRATION_YEAR = new ExperationYear();
	public static final FieldRule HEIGHT = new Height();
	public static final FieldRule HAIR_COLOR = new HairColor();
	public static final FieldRule EYE_COLOR = new EyeColor();
	public static final FieldRule PASSPORT_ID = new PassportId();

	@Override
	public Validation isValid(Passport passport) {
		for(FieldRule fieldRule : all()) {
			if(passport.matchesFieldRule(fieldRule) != Validation.VALID) {
				return Validation.INVALID;
			}
		}
		return Validation.VALID;
	}

	private List<FieldRule> all() {
		return List.of(
				ISSUE_YEAR,
				BIRTH_YEAR,
				EXPIRATION_YEAR,
				HEIGHT,
				HAIR_COLOR,
				EYE_COLOR,
				PASSPORT_ID
		);
	}
}
