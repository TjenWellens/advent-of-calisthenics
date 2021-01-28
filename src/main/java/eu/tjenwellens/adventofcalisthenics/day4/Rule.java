package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Rule {
	private final List<Field.Key> keys;

	public boolean check(Passport passport) {
		if (passport.matchesFieldCount(keys.size()) && passport.containsFieldKeys(keys))
			return true;
		return false;
	}
}
