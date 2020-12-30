package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
@ToString
public class Password {
	private final String password;

	private Collection<Letter> letters() {
		return Arrays.stream(password.split("")).map(Letter::new).collect(Collectors.toList());
	}

	public int occurencesOf(Letter policyLetter) {
		return (int) letters().stream().filter(letter -> letter.equals(policyLetter)).count();
	}
}
