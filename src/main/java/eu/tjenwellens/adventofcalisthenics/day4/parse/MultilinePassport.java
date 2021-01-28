package eu.tjenwellens.adventofcalisthenics.day4.parse;

import eu.tjenwellens.adventofcalisthenics.day4.passport.Field;
import eu.tjenwellens.adventofcalisthenics.day4.passport.Passport;
import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
class MultilinePassport {
	private final List<String> lines;

	public Passport parsePassword() {
		List<Field> fields = new LinkedList<>();
		for (String line : lines) {
			fields.addAll(parseFields(line));
		}
		return new Passport(fields);
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
