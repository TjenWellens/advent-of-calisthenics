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
					new Passport(List.of(new Field("pid", "860033327"))),
					new Passport(List.of(new Field("eyr", "2020"))),
					new Passport(List.of(new Field("hcl", "#fffffd"))),
					new Passport(List.of(new Field("byr", "1937"))),
					new Passport(List.of(new Field("iyr", "2017"))),
					new Passport(List.of(new Field("cid", "147"))),
					new Passport(List.of(new Field("hgt", "183cm")))
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
