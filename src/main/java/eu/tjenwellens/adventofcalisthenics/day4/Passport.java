package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Passport{
	private final List<Field> fields;

	public boolean has8fields() {
		return fields.size() == 8;
	}
}
