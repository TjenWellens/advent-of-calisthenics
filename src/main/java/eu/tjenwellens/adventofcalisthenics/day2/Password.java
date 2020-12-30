package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Password {
	private final String password;

	public boolean contains(String a) {
		return password.contains(a);
	}

	public int length() {
		return password.length();
	}

	public boolean contains(Letter policyLetter) {
		return letters().contains(policyLetter);
	}

	private Collection<Letter> letters() {
		return Arrays.stream(password.split("")).map(Letter::new).collect(Collectors.toList());
	}
}
