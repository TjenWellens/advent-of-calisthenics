package eu.tjenwellens.adventofcalisthenics.day2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Password {
	private final String password;

	private Collection<Letter> letters() {
		return Arrays.stream(password.split("")).map(Letter::new).collect(Collectors.toList());
	}

	public LetterOccurs occurrencesOf(Letter policyLetter) {
		return new LetterOccurs(letters().stream().filter(letter -> letter.equals(policyLetter)).count());
	}

	public boolean letterAtPositionEquals(Letter letter, Position position) {
		return letter.equals(getLetter(position));
	}

	private Letter getLetter(Position position) {
		final char aChar = password.toCharArray()[position.getPosition()];
		return new Letter("" + aChar);
	}

	static Password of(String line) {
		return new Password(line.split(": ")[1]);
	}
}
