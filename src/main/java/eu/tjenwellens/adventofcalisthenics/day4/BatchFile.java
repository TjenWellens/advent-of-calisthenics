package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
public class BatchFile {
	private final List<String> lines;

	public Passports parse() {
		if(lines.size() > 1) {
			return new Passports(List.of(
					new Passport(parseFields(lines.get(0))),
					new Passport(parseFields(lines.get(2))),
					new Passport(parseFields(lines.get(4))),
					new Passport(parseFields(lines.get(6))),
					new Passport(parseFields(lines.get(8))),
					new Passport(parseFields(lines.get(10))),
					new Passport(parseFields(lines.get(12))),
					new Passport(parseFields(lines.get(14)))
			));
		}

		return new Passports(List.of(
				new Passport(parseFields(lines.get(0)))
		));
	}

	private List<Field> parseFields(String line) {
		final String[] split = line.trim().split(":");
		final Field field = new Field(split[0], split[1]);
		return List.of(field);
	}
}
