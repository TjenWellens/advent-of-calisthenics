package eu.tjenwellens.adventofcalisthenics.day4.rule;


import eu.tjenwellens.adventofcalisthenics.day4.passport.Passport;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import eu.tjenwellens.adventofcalisthenics.day4.rule.key.KeyRules;
import eu.tjenwellens.adventofcalisthenics.day4.rule.value.ValueRules;

public class FieldRules implements Rules {
	private final KeyRules keys = new KeyRules();
	private final ValueRules values = new ValueRules();

	@Override
	public Validation isValid(Passport passport) {
		if(keys.isValid(passport) == Validation.INVALID)
			return Validation.INVALID;
		if(values.isValid(passport) == Validation.INVALID)
			return Validation.INVALID;
		return Validation.VALID;
	}
}
