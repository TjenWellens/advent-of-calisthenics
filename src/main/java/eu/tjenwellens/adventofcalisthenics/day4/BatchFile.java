package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public class BatchFile {
	private final List<String> lines;

	public Passports parse() {
		List<Passport> result = new LinkedList<>();

		if (lines.size() > 1) {
			result.add(new Passport(parseFields(lines.get(0))));
			result.add(new Passport(parseFields(lines.get(2))));
			result.add(new Passport(parseFields(lines.get(4))));
			result.add(new Passport(parseFields(lines.get(6))));
			result.add(new Passport(parseFields(lines.get(8))));
			result.add(new Passport(parseFields(lines.get(10))));
			result.add(new Passport(parseFields(lines.get(12))));
			result.add(new Passport(parseFields(lines.get(14))));
		} else {
			result.add(new Passport(parseFields(lines.get(0))));
		}

		return new Passports(result);
	}

	private List<Field> parseFields(String line) {
		final String[] split = line.trim().split(":");
		final Field field = new Field(split[0], split[1]);
		return List.of(field);
	}
}
