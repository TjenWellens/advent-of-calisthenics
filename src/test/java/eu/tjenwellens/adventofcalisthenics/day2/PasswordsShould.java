package eu.tjenwellens.adventofcalisthenics.day2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordsShould {
	@Disabled
	@Test
	void count_valid_passwords() {
		final List<String> input = List.of(
				"1-3 a: abcde",
				"1-3 b: cdefg",
				"2-9 c: ccccccccc"
		);
		assertThat(new ValidPasswordCounter().count(input)).isEqualTo(new PasswordCount(2));
	}
}
