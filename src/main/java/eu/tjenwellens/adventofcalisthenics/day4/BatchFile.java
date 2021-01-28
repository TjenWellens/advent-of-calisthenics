package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public class BatchFile {
	private final List<String> lines;

	public Passports parse() {
		List<Passport> result = new LinkedList<>();
		for (String line : lines) {
			if (line.isBlank()) continue;
			result.add(new Passport(parseFields(line)));
		}
		return new Passports(result);
	}

	private List<Field> parseFields(String line) {
		final String[] fieldStrings = line.trim().split(" ");
		final List<Field> result = new LinkedList<>();
		for (String fieldString : fieldStrings) {
			result.add(parseField(fieldString));
		}
		return result;
	}

	private Field parseField(String fieldString) {
		final String[] split = fieldString.trim().split(":");
		return new Field(split[0], split[1]);
	}
}
