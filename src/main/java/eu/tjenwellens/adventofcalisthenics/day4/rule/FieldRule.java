package eu.tjenwellens.adventofcalisthenics.day4.rule;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.Validation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class FieldRule {
	private final Field.Key key;

	public abstract Validation isValid(Field field);

	public boolean appliesTo(Field field) {
		return field.hasKey(key);
	}
}
