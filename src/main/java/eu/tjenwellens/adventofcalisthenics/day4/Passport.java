package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Passport {
	private final List<Field> fields;

	public boolean has8fields() {
		return fields.size() == 8;
	}

	public boolean containsFieldKeys(List<Field.Key> keys) {
		for (Field.Key key : keys) {
			if (!isKeyPresent(key)) {
				return false;
			}
		}
		return true;
	}

	private boolean isKeyPresent(Field.Key key) {
		for (Field field : fields) {
			if (field.hasKey(key)) return true;
		}
		return false;
	}

	public boolean has7fields() {
		return fields.size() == 7;
	}
}
