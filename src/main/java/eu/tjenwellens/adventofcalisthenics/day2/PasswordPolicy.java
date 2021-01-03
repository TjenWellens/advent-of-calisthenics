package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

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

	public static class PasswordValidation {
		public static final PasswordValidation VALID = new PasswordValidation();
		public static final PasswordValidation INVALID = new PasswordValidation();
	}

	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	protected static class Number {
		private final int number;

		public int getNumber() {
			return number;
		}
	}
}
