package eu.tjenwellens.adventofcalisthenics.day4;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportScannerSpec {
	@Disabled
	@Test
	void scanner_counts_valid_passports() {
		final List<String> lines = Arrays.asList("""
							ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
							byr:1937 iyr:2017 cid:147 hgt:183cm

							iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
							hcl:#cfa07d byr:1929

							hcl:#ae17e1 iyr:2013
							eyr:2024
							ecl:brn pid:760753108 byr:1931
							hgt:179cm

							hcl:#cfa07d eyr:2025 pid:166559648
							iyr:2011 ecl:brn hgt:59in
				""".split("\n"));

		final BatchFile batchFile = new BatchFile(lines);

		assertThat(new PassportScanner().countValidPassports(batchFile)).isEqualTo(new PassportCount(2));
	}

	@DisplayName("a batchfile")
	@Nested
	class ABatchFile {
		@Test
		void can_parse_a_single_line_single_field_password() {
			final List<String> lines = Arrays.asList("""
								ecl:gry
					""".split("\n"));

			final BatchFile batchFile = new BatchFile(lines);

			assertThat(batchFile.parse()).isEqualTo(new Passports(List.of(
					new Passport(List.of(new Field("ecl", "gry")))
			)));
		}

		@Test
		void can_parse_multiple_single_line_single_field_passwords() {
			final List<String> lines = Arrays.asList("""
								ecl:gry

								pid:860033327

								eyr:2020

								hcl:#fffffd

								byr:1937

								iyr:2017

								cid:147

								hgt:183cm
					""".split("\n"));

			final BatchFile batchFile = new BatchFile(lines);

			assertThat(batchFile.parse()).isEqualTo(new Passports(List.of(
					new Passport(List.of(new Field("ecl", "gry"))),
					new Passport(List.of(new Field("pid", "860033327"))),
					new Passport(List.of(new Field("eyr", "2020"))),
					new Passport(List.of(new Field("hcl", "#fffffd"))),
					new Passport(List.of(new Field("byr", "1937"))),
					new Passport(List.of(new Field("iyr", "2017"))),
					new Passport(List.of(new Field("cid", "147"))),
					new Passport(List.of(new Field("hgt", "183cm")))
			)));
		}

		@Test
		void can_parse_a_password_with_multiple_fields_on_a_single_line() {
			final List<String> lines = Arrays.asList("""
								ecl:gry pid:860033327
					""".split("\n"));

			final BatchFile batchFile = new BatchFile(lines);

			assertThat(batchFile.parse()).isEqualTo(new Passports(List.of(
					new Passport(List.of(new Field("ecl", "gry"), new Field("pid", "860033327")))
			)));
		}

		@Test
		void can_parse_a_password_with_fields_on_multiple_lines() {
			final List<String> lines = Arrays.asList("""
								ecl:gry
								pid:860033327
					""".split("\n"));

			final BatchFile batchFile = new BatchFile(lines);

			assertThat(batchFile.parse()).isEqualTo(new Passports(List.of(
					new Passport(List.of(new Field("ecl", "gry"), new Field("pid", "860033327")))
			)));
		}

		@Test
		void can_parse_a_password_with_multiple_fields_on_multiple_lines() {
			final List<String> lines = Arrays.asList("""
								ecl:gry hcl:#fffffd
								pid:860033327
								byr:1937
					""".split("\n"));

			final BatchFile batchFile = new BatchFile(lines);

			assertThat(batchFile.parse()).isEqualTo(new Passports(List.of(
					new Passport(List.of(
							new Field("ecl", "gry"),
							new Field("hcl", "#fffffd"),
							new Field("pid", "860033327"),
							new Field("byr", "1937")
					))
			)));
		}
	}

	@DisplayName("a passport")
	@Nested
	class APassport {
		@DisplayName("is valid")
		@Nested
		class IsValid {
			@Test
			void when_all_eight_fields_are_present() {
				final Passport passport = new Passport(List.of(
						new Field("ecl", "gry"),
						new Field("pid", "860033327"),
						new Field("eyr", "2020"),
						new Field("hcl", "#fffffd"),
						new Field("byr", "1937"),
						new Field("iyr", "2017"),
						new Field("cid", "147"),
						new Field("hgt", "183cm")
				));
				assertThat(new PassportScanner().isValid(passport)).isEqualTo(Validation.VALID);
			}

			@Test
			void when_only_missing_cid() {
				final Passport passport = new Passport(List.of(
						new Field("ecl", "gry"),
						new Field("pid", "860033327"),
						new Field("eyr", "2020"),
						new Field("hcl", "#fffffd"),
						new Field("byr", "1937"),
						new Field("iyr", "2017"),
						new Field("hgt", "183cm")
				));
				assertThat(new PassportScanner().isValid(passport)).isEqualTo(Validation.VALID);
			}
		}

		@DisplayName("is invalid")
		@Nested
		class IsInvalid {
			@Test
			void when_missing_a_field_other_than_cid() {
				final Passport passport = new Passport(List.of(
						new Field("pid", "860033327"),
						new Field("eyr", "2020"),
						new Field("hcl", "#fffffd"),
						new Field("byr", "1937"),
						new Field("iyr", "2017"),
						new Field("cid", "147"),
						new Field("hgt", "183cm")
				));
				assertThat(new PassportScanner().isValid(passport)).isEqualTo(Validation.INVALID);
			}

			@Test
			void when_8_fields_are_present_but_one_unknown_field_is_present() {
				final Passport passport = new Passport(List.of(
						new Field("foo", "bar"),
						new Field("pid", "bar"),
						new Field("eyr", "bar"),
						new Field("hcl", "bar"),
						new Field("byr", "bar"),
						new Field("iyr", "bar"),
						new Field("cid", "bar"),
						new Field("hgt", "bar")
				));
				assertThat(new PassportScanner().isValid(passport)).isEqualTo(Validation.INVALID);
			}
		}
	}

	@DisplayName("a passport validator")
	@Nested
	class APassportValidator {
		@Test
		void counts_a_valid_passport() {
			final List<String> lines = Arrays.asList("""
							ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
							byr:1937 iyr:2017 cid:147 hgt:183cm
				""".split("\n"));

			final BatchFile batchFile = new BatchFile(lines);

			assertThat(new PassportScanner().countValidPassports(batchFile)).isEqualTo(new PassportCount(1));
		}
		@Test
		void counts_all_valid_passports() {
			final List<String> lines = Arrays.asList("""
							ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
							byr:1937 iyr:2017 cid:147 hgt:183cm

							ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
							byr:1937 iyr:2017 cid:147 hgt:183cm
				""".split("\n"));

			final BatchFile batchFile = new BatchFile(lines);

			assertThat(new PassportScanner().countValidPassports(batchFile)).isEqualTo(new PassportCount(2));
		}
	}
}
