package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Field {
	private final String key;
	private final String value;

	public boolean hasKey(Key key) {
		return this.key.equals(key.key);
	}

	public Validation valueBetween(int minimum, int maximum) {
		final int value = Integer.parseInt(this.value);
		return minimum <= value && value <= maximum ? Validation.VALID : Validation.INVALID;
	}

	@AllArgsConstructor
	public static class Key {
		private final String key;
	}
}
