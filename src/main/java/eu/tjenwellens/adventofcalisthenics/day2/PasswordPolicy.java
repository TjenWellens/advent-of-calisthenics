package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class PasswordPolicy {
	private final String policy;

	public abstract boolean validate(Password password);

	protected int _policyStartOccurrence() {
		return Integer.parseInt(policy.split(" ")[0].split("-")[0]);
	}

	protected int _policyEndOccurrence() {
		return Integer.parseInt(policy.split(" ")[0].split("-")[1]);
	}

	protected Letter policyLetter() {
		return new Letter(policy.split(" ")[1]);
	}

}
