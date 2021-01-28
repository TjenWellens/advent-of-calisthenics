package eu.tjenwellens.adventofcalisthenics.day4.rule;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Passport;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

public interface Rules {
	Validation isValid(Passport passport);
}
