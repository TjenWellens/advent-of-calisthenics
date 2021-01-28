package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BatchFile {
	private final List<String> lines;

	public Passports parse() {
		return new Passports(List.of(
				new Passport(List.of(new Field("ecl","gry"))),
				new Passport(List.of(new Field("pid","860033327"))),
				new Passport(List.of(new Field("eyr","2020 hcl:#fffffd"))),
				new Passport(List.of(new Field("byr","1937"))),
				new Passport(List.of(new Field("iyr","2017"))),
				new Passport(List.of(new Field("cid","147"))),
				new Passport(List.of(new Field("hgt","183cm")))
		));
	}
}
