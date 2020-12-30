package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordAndPasswordPolicy {
	private final String line;

	public boolean isValid() {
		if (line.contains("a"))
			return !line.contains("b");
		return true;
	}
}
