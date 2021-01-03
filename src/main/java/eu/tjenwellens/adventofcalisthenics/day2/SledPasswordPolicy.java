package eu.tjenwellens.adventofcalisthenics.day2;

public class SledPasswordPolicy extends PasswordPolicy {
	protected SledPasswordPolicy(String policy) {
		super(policy);
	}

	static PasswordPolicy of(String line) {
		return new PasswordPolicy(line.split(": ")[0]);
	}
}
