package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public class BatchFile {
	private final List<String> lines;

	public Passports parse() {
		Passports.PassportsBuilder result = Passports.builder();
		List<Field> fields = new LinkedList<>();
		for (String line : lines) {
			if (line.isBlank()) {
				result.passport(new Passport(fields));
				fields = new LinkedList<>();
				continue;
			}

			fields.addAll(parseFields(line));
		}
		result.passport(new Passport(fields));
		return result.build();
	}

	private List<Field> parseFields(String line) {
		final List<Field> result = new LinkedList<>();
		for (String fieldString : parseFieldStrings(line)) {
			result.add(parseField(fieldString));
		}
		return result;
	}

	private String[] parseFieldStrings(String line) {
		return line.trim().split(" ");
	}

	private Field parseField(String fieldString) {
		final String[] split = fieldString.trim().split(":");
		return new Field(split[0], split[1]);
	}
}
