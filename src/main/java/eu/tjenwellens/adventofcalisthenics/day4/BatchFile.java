package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public class BatchFile {
	private final List<String> lines;

	public Passports parse() {
		Passports.PassportsBuilder result = Passports.builder();
		for (List<String> lines : groupLinesDelimitedByBlankLine()) {
			result.passport(parsePassword(lines));
		}
		return result.build();
	}

	private Passport parsePassword(List<String> lines) {
		List<Field> fields = new LinkedList<>();
		for (String line : lines) {
			fields.addAll(parseFields(line));
		}
		return new Passport(fields);
	}

	private List<List<String>> groupLinesDelimitedByBlankLine() {
		List<List<String>> result = new LinkedList<>();
		List<String> linesForCurrentPassword = new LinkedList<>();
		for (String line : lines) {
			if (line.isBlank()) {
				result.add(linesForCurrentPassword);
				linesForCurrentPassword = new LinkedList<>();
				continue;
			}

			linesForCurrentPassword.add(line);
		}
		result.add(linesForCurrentPassword);
		return result;
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
