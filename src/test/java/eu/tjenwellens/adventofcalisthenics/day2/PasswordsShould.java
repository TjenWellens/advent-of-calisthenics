package eu.tjenwellens.adventofcalisthenics.day2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordsShould {
	@Test
	void count_valid_passwords() {
		final List<String> input = List.of(
				"1-3 a: abcde",
				"1-3 b: cdefg",
				"2-9 c: ccccccccc"
		);
		ValidPasswordCounter counter = ValidPasswordCounter.create(input);
		assertThat(counter.countValidPasswords())
				.isEqualTo(new PasswordCount(2));
	}

	@Test
	void valid_password_is_counted() {
		final List<String> input = List.of(
				"1-2 a: a"
		);
		ValidPasswordCounter counter = ValidPasswordCounter.create(input);
		assertThat(counter.countValidPasswords())
				.isEqualTo(new PasswordCount(1));
	}

	@Test
	void no_passwords_count_as_0() {
		final List<String> input = List.of();
		ValidPasswordCounter counter = ValidPasswordCounter.create(input);
		assertThat(counter.countValidPasswords())
				.isEqualTo(new PasswordCount(0));
	}

	@Test
	void invalid_password_is_not_counted() {
		final List<String> input = List.of(
				"1-2 a: b"
		);
		ValidPasswordCounter counter = ValidPasswordCounter.create(input);
		assertThat(counter.countValidPasswords())
				.isEqualTo(new PasswordCount(0));
	}

	@Test
	void invalid_passwords_are_not_counted() {
		final List<String> input = List.of(
				"1-2 a: a",
				"1-2 a: b"
		);
		ValidPasswordCounter counter = ValidPasswordCounter.create(input);
		assertThat(counter.countValidPasswords())
				.isEqualTo(new PasswordCount(1));
	}

	@Test
	void compare_policy_letter_with_input() {
		final List<String> input = List.of(
				"1-2 b: b"
		);
		ValidPasswordCounter counter = ValidPasswordCounter.create(input);
		assertThat(counter.countValidPasswords())
				.isEqualTo(new PasswordCount(1));
	}

	@Test
	void compare_policy_amount_with_input() {
		final List<String> input = List.of(
				"1-2 a: aaa"
		);
		ValidPasswordCounter counter = ValidPasswordCounter.create(input);
		assertThat(counter.countValidPasswords())
				.isEqualTo(new PasswordCount(0));
	}

	@Disabled
	@Test
	void part1_input() throws IOException {
		final Path path = Paths.get("src", "test", "resources", "day-2-input.txt");
		final List<String> input = Files.readAllLines(path);
		ValidPasswordCounter counter = ValidPasswordCounter.create(input);
		assertThat(counter.countValidPasswords())
				.isEqualTo(new PasswordCount(569));
	}
}
