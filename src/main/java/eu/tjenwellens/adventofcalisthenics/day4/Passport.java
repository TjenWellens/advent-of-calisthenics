package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Passport{
	private final List<Field> fields;
}
