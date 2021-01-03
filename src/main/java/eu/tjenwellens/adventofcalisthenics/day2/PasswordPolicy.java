package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class PasswordPolicy {
	private final String policy;

	public abstract PasswordValidation validate(Password password);

	protected Number _policyStartOccurrence() {
		return new Number(Integer.parseInt(policy.split(" ")[0].split("-")[0]));
	}

	protected Number _policyEndOccurrence() {
		return new Number(Integer.parseInt(policy.split(" ")[0].split("-")[1]));
	}

	protected Letter policyLetter() {
		return new Letter(policy.split(" ")[1]);
	}

	public enum PasswordValidation {
		VALID, INVALID
	}

	@AllArgsConstructor(access = AccessLevel.PROTECTED)
	protected static class Number {
		protected final int number;
	}
}
