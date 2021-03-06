package eu.tjenwellens.adventofcalisthenics.day2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static eu.tjenwellens.adventofcalisthenics.day2.PasswordPolicy.PasswordValidation.INVALID;
import static eu.tjenwellens.adventofcalisthenics.day2.PasswordPolicy.PasswordValidation.VALID;
import static org.assertj.core.api.Assertions.assertThat;

public class PasswordsShould {
	@Disabled
	@Test
	void count_valid_sled_rental_passwords() {
		final List<String> input = List.of(
				"1-3 a: abcde",
				"1-3 b: cdefg",
				"2-9 c: ccccccccc"
		);
		ValidPasswordCounter counter = ValidPasswordCounter.createSledRental(input);
		assertThat(counter.countValidPasswords())
				.isEqualTo(new PasswordCount(2));
	}

	@Disabled
	@Test
	void count_valid_toboggan_rental_passwords() {
		final List<String> input = List.of(
				"1-3 a: abcde",
				"1-3 b: cdefg",
				"2-9 c: ccccccccc"
		);
		ValidPasswordCounter counter = ValidPasswordCounter.createTobogganRental(input);
		assertThat(counter.countValidPasswords())
				.isEqualTo(new PasswordCount(1));
	}

	@Nested
	class Count {
		@Test
		void single_valid() {
			final List<String> input = List.of(
					"1-2 a: a"
			);
			ValidPasswordCounter counter = ValidPasswordCounter.createSledRental(input);
			assertThat(counter.countValidPasswords())
					.isEqualTo(new PasswordCount(1));
		}


		@Test
		void no_passwords_count_as_0() {
			final List<String> input = List.of();
			ValidPasswordCounter counter = ValidPasswordCounter.createSledRental(input);
			assertThat(counter.countValidPasswords())
					.isEqualTo(new PasswordCount(0));
		}

		@Test
		void single_invalid() {
			final List<String> input = List.of(
					"1-2 a: b"
			);
			ValidPasswordCounter counter = ValidPasswordCounter.createSledRental(input);
			assertThat(counter.countValidPasswords())
					.isEqualTo(new PasswordCount(0));
		}

		@Test
		void multiple_mixed() {
			final List<String> input = List.of(
					"1-2 a: a",
					"1-2 a: b"
			);
			ValidPasswordCounter counter = ValidPasswordCounter.createSledRental(input);
			assertThat(counter.countValidPasswords())
					.isEqualTo(new PasswordCount(1));
		}
	}

	@Nested
	class Validate_SledRental {
		@Nested
		class Valid {
			@Test
			void when_policy_letter_found_a() {
				assertThat(PasswordAndPasswordPolicy.sledRental("1-2 a: a").isValid()).isEqualTo(VALID);
			}

			@Test
			void when_policy_letter_found_b() {
				assertThat(PasswordAndPasswordPolicy.sledRental("1-2 b: b").isValid()).isEqualTo(VALID);
			}

		}

		@Nested
		class Invalid {
			@Test
			void when_policy_range_mismatch() {
				assertThat(PasswordAndPasswordPolicy.sledRental("1-2 a: aaa").isValid()).isEqualTo(INVALID);
			}

			@Test
			void when_policy_letter_not_found() {
				assertThat(PasswordAndPasswordPolicy.sledRental("1-2 a: b").isValid()).isEqualTo(INVALID);
			}
		}
	}

	@Nested
	class Validate_TobogganRental {
		@Nested
		class Valid {
			@Test
			void when_only_first_policy_position_contains_policy_letter() {
				assertThat(PasswordAndPasswordPolicy.tobogganRental("1-3 a: abcde").isValid()).isEqualTo(VALID);
			}
			@Test
			void when_only_second_policy_position_contains_policy_letter() {
				assertThat(PasswordAndPasswordPolicy.tobogganRental("1-3 a: bba").isValid()).isEqualTo(VALID);
			}
		}

		@Nested
		class Invalid {
			@Test
			void when_exactly_no_policy_position_contains_policy_letter() {
				assertThat(PasswordAndPasswordPolicy.tobogganRental("1-3 b: abc").isValid()).isEqualTo(INVALID);
			}
			@Test
			void when_both_policy_positions_contain_policy_letter() {
				assertThat(PasswordAndPasswordPolicy.tobogganRental("1-3 a: aba").isValid()).isEqualTo(INVALID);
			}
		}
	}

	@Disabled
	@Test
	void part1_input() throws IOException {
		final Path path = Paths.get("src", "test", "resources", "day-2-input.txt");
		final List<String> input = Files.readAllLines(path);
		ValidPasswordCounter counter = ValidPasswordCounter.createSledRental(input);
		assertThat(counter.countValidPasswords())
				.isEqualTo(new PasswordCount(569));
	}

	@Disabled
	@Test
	void part2_input() throws IOException {
		final Path path = Paths.get("src", "test", "resources", "day-2-input.txt");
		final List<String> input = Files.readAllLines(path);
		ValidPasswordCounter counter = ValidPasswordCounter.createTobogganRental(input);
		assertThat(counter.countValidPasswords())
				.isEqualTo(new PasswordCount(346));
	}
}
