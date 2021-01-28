package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.*;

import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Passports implements Iterable<Passport> {
	@Singular
	private final List<Passport> passports;

	@Override
	public Iterator<Passport> iterator() {
		return passports.iterator();
	}
}
