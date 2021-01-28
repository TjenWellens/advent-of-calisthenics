package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Rule {
	private final List<Field.Key> keys;

	public Validation check(Passport passport) {
		if (!passport.matchesFieldCount(keys.size()))
			return Validation.INVALID;
		if (!passport.containsFieldKeys(keys))
			return Validation.INVALID;
		return Validation.VALID;
	}
}
