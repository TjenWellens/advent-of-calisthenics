package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
public class LetterOccurs {
	private final long occurrences;

	public boolean isBetween(LetterOccurs startInclusive, LetterOccurs endInclusive) {
		return startInclusive.occurrences <= occurrences && occurrences <= endInclusive.occurrences;
	}
}
