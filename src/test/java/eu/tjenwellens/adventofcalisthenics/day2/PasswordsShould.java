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
		assertThat(ValidPasswordCounter.create(input).count()).isEqualTo(new PasswordCount(2));
	}

	@Test
	void valid_password_is_counted() {
		final List<String> input = List.of(
				"1-2 a: a"
		);
		assertThat(ValidPasswordCounter.create(input).count()).isEqualTo(new PasswordCount(1));
	}

	@Test
	void no_passwords_count_as_0() {
		final List<String> input = List.of();
		assertThat(ValidPasswordCounter.create(input).count()).isEqualTo(new PasswordCount(0));
	}

	@Test
	void invalid_password_is_not_counted() {
		final List<String> input = List.of(
				"1-2 a: b"
		);
		assertThat(ValidPasswordCounter.create(input).count()).isEqualTo(new PasswordCount(0));
	}

	@Test
	void invalid_passwords_are_not_counted() {
		final List<String> input = List.of(
				"1-2 a: a",
				"1-2 a: b"
		);
		assertThat(ValidPasswordCounter.create(input).count()).isEqualTo(new PasswordCount(1));
	}
}
