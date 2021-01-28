package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BatchFile {
	private final List<String> lines;

	public Passports parse() {
		final String[] split = lines.get(0).trim().split(":");

		return new Passports(List.of(
				new Passport(List.of(new Field(split[0],split[1])))
		));
	}
}
