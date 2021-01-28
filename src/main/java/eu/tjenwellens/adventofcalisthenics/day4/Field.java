package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
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

	public boolean valueEndsWith(String suffix) {
		return value.endsWith(suffix);
	}

	public Field withoutSuffix(String suffix) {
		final String valueWithoutSuffix = value.substring(0, value.length() - suffix.length());
		return new Field(key, valueWithoutSuffix);
	}

	public Validation isHexColor() {
		return value.matches("#[0-9a-f]{6}") ? Validation.VALID : Validation.INVALID;
	}

	public boolean valueEquals(Value value) {
		return this.value.equals(value.value);
	}

	@AllArgsConstructor
	public static class Key {
		private final String key;
	}

	@AllArgsConstructor
	public static class Value {
		private final String value;
	}
}
