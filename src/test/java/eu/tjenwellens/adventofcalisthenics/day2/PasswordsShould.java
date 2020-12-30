package eu.tjenwellens.adventofcalisthenics.day2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		ValidPasswordCounter counter = ValidPasswordCounter.create(input);
		assertThat(counter.countValidPasswords())
				.isEqualTo(new PasswordCount(2));
	}

	@Nested
	class Count {
		@Test
		void single_valid() {
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
		void single_invalid() {
			final List<String> input = List.of(
					"1-2 a: b"
			);
			ValidPasswordCounter counter = ValidPasswordCounter.create(input);
			assertThat(counter.countValidPasswords())
					.isEqualTo(new PasswordCount(0));
		}

		@Test
		void multiple_mixed() {
			final List<String> input = List.of(
					"1-2 a: a",
					"1-2 a: b"
			);
			ValidPasswordCounter counter = ValidPasswordCounter.create(input);
			assertThat(counter.countValidPasswords())
					.isEqualTo(new PasswordCount(1));
		}
	}

	@Nested
	class Validate {
		@Nested
		class Valid {
			@Test
			void when_policy_letter_found_a() {
				assertThat(new PasswordAndPasswordPolicy("1-2 a: a").isValid()).isTrue();
			}

			@Test
			void when_policy_letter_found_b() {
				assertThat(new PasswordAndPasswordPolicy("1-2 b: b").isValid()).isTrue();
			}

		}

		@Nested
		class Invalid {
			@Test
			void when_policy_range_mismatch() {
				assertThat(new PasswordAndPasswordPolicy("1-2 a: aaa").isValid()).isFalse();
			}

			@Test
			void when_policy_letter_not_found() {
				assertThat(new PasswordAndPasswordPolicy("1-2 a: b").isValid()).isFalse();
			}
		}
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
