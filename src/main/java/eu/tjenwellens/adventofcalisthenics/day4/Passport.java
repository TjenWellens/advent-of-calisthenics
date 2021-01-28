package eu.tjenwellens.adventofcalisthenics.day4;

import eu.tjenwellens.adventofcalisthenics.day4.rule.field.FieldRule;
import eu.tjenwellens.adventofcalisthenics.day4.rule.field.FieldRules;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Passport {
	private final List<Field> fields;

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

	public boolean matchesFieldCount(int fieldCount) {
		return fields.size() == fieldCount;
	}

	public Validation matchesFieldRule(FieldRule rule) {
		return findFieldFor(rule)
				.map(rule::isValid)
				.orElse(Validation.INVALID);
	}

	private Optional<Field> findFieldFor(FieldRule rule) {
		for(Field field : fields) {
			if(rule.appliesTo(field)) return Optional.of(field);
		}
		return Optional.empty();
	}
}
