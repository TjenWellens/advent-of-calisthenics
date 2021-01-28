package eu.tjenwellens.adventofcalisthenics;

import eu.tjenwellens.adventofcalisthenics.day4.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;

public interface FieldRule {
	Validation isValid(Field field);
}
