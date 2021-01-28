package eu.tjenwellens.adventofcalisthenics.day4;

public class PassportScanner {
	private static final Rules rules = new Rules();

	public PassportCount countValidPassports(BatchFile batchFile) {
		final Passports passports = batchFile.parse();
		return passports.countValid(rules);
	}
}
