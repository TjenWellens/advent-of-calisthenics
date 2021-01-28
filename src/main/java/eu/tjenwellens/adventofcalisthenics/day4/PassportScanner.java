package eu.tjenwellens.adventofcalisthenics.day4;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PassportScanner {
	private final Rules rules;

	public PassportCount countValidPassports(BatchFile batchFile) {
		final Passports passports = batchFile.parse();
		return passports.countValid(rules);
	}
}
