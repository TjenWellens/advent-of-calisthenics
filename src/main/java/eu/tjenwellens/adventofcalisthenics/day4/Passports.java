package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Passports {
	@Singular
	private final List<Passport> passports;
}
