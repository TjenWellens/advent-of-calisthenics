package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BatchFile {
	private final List<String> lines;

	public Passports parse() {
		final String line = lines.get(0);
		final List<Field> fields = parseFields(line);
		return new Passports(List.of(
				new Passport(fields)
		));
	}

	private List<Field> parseFields(String line) {
		final String[] split = line.trim().split(":");
		final Field field = new Field(split[0], split[1]);
		return List.of(field);
	}
}
