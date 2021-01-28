package eu.tjenwellens.adventofcalisthenics.day4;

public class PassportScanner {
	private static final Rules rules = new Rules();

	public PassportCount countValidPassports(BatchFile batchFile) {
		int result = 0;
		for (Passport passport : batchFile.parse())
			if (rules.isValid(passport) == Validation.VALID)
				result++;
		return new PassportCount(result);
	}
}
