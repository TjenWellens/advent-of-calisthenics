package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Password {
	private final String password;

	public boolean contains(String a) {
		return password.contains(a);
	}
}
