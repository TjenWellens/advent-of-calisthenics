package eu.tjenwellens.adventofcalisthenics.day4;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Passport;
import eu.tjenwellens.adventofcalisthenics.day4.rule.Rules;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Passports {
	@Singular
	private final List<Passport> passports;

	public PassportCount countValid(Rules rules) {
		int result = 0;
		for (Passport passport : passports)
			if (rules.isValid(passport) == Validation.VALID)
				result++;
		return new PassportCount(result);
	}
}
