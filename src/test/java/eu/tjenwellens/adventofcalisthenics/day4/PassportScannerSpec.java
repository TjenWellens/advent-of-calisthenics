package eu.tjenwellens.adventofcalisthenics.day4;

import eu.tjenwellens.adventofcalisthenics.day4.rule.field.FieldRules;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportScannerSpec {
	@Nested
	class V1_KeyValidation {
		private final PassportScanner scanner = new PassportScanner(new KeyRules());

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

			assertThat(scanner.countValidPassports(batchFile)).isEqualTo(new PassportCount(2));
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
			private final Rules rules = new KeyRules();

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
					assertThat(rules.isValid(passport)).isEqualTo(Validation.VALID);
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
					assertThat(rules.isValid(passport)).isEqualTo(Validation.VALID);
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
					assertThat(rules.isValid(passport)).isEqualTo(Validation.INVALID);
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
					assertThat(rules.isValid(passport)).isEqualTo(Validation.INVALID);
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

				assertThat(scanner.countValidPassports(batchFile)).isEqualTo(new PassportCount(1));
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

				assertThat(scanner.countValidPassports(batchFile)).isEqualTo(new PassportCount(2));
			}

			@Test
			void does_not_count_an_invalid_passport() {
				final List<String> lines = Arrays.asList("""
									ecl:gry hgt:183cm
						""".split("\n"));

				final BatchFile batchFile = new BatchFile(lines);

				assertThat(scanner.countValidPassports(batchFile)).isEqualTo(new PassportCount(0));
			}
		}

		@Disabled
		@Test
		void part1_input() throws IOException {
			final Path path = Paths.get("src", "test", "resources", "day-4-input.txt");
			final List<String> lines = Files.readAllLines(path);
			final BatchFile batchFile = new BatchFile(lines);
			assertThat(scanner.countValidPassports(batchFile)).isEqualTo(new PassportCount(226));
		}
	}

	@Nested
	class V2_FieldValueValidation {
		@Disabled
		@Nested
		class AcceptanceTest {
			private final PassportScanner scanner = new PassportScanner(new FieldRules());

			@Test
			void scanner_counts_valid_passports() {
				final List<String> lines = Arrays.asList("""
									pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980
									hcl:#623a2f

									eyr:2029 ecl:blu cid:129 byr:1989
									iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm

									hcl:#888785
									hgt:164cm byr:2001 iyr:2015 cid:88
									pid:545766238 ecl:hzl
									eyr:2022

									iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719
						""".split("\n"));

				final BatchFile batchFile = new BatchFile(lines);

				assertThat(scanner.countValidPassports(batchFile)).isEqualTo(new PassportCount(4));
			}

			@Test
			void scanner_does_not_count_invalid_passports() {
				final List<String> lines = Arrays.asList("""
								 eyr:1972 cid:100
								 hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926

								 iyr:2019
								 hcl:#602927 eyr:1967 hgt:170cm
								 ecl:grn pid:012533040 byr:1946

								 hcl:dab227 iyr:2012
								 ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277

								 hgt:59cm ecl:zzz
								 eyr:2038 hcl:74454a iyr:2023
								 pid:3556412378 byr:2007
						""".split("\n"));

				final BatchFile batchFile = new BatchFile(lines);

				assertThat(scanner.countValidPassports(batchFile)).isEqualTo(new PassportCount(0));
			}
		}

		@Nested
		class ValueRulesTest {
			@Test
			void birth_year_is_valid_when_between_1920_and_2002() {
				assertThat(FieldRules.BIRTH_YEAR.isValid(new Field("byr", "1900"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.BIRTH_YEAR.isValid(new Field("byr", "1919"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.BIRTH_YEAR.isValid(new Field("byr", "1920"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.BIRTH_YEAR.isValid(new Field("byr", "1930"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.BIRTH_YEAR.isValid(new Field("byr", "2002"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.BIRTH_YEAR.isValid(new Field("byr", "2003"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.BIRTH_YEAR.isValid(new Field("byr", "2100"))).isEqualTo(Validation.INVALID);
			}
			@Test
			void issue_year_is_valid_when_between_2010_and_2020() {
				assertThat(FieldRules.ISSUE_YEAR.isValid(new Field("iyr", "1900"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.ISSUE_YEAR.isValid(new Field("iyr", "2009"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.ISSUE_YEAR.isValid(new Field("iyr", "2010"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.ISSUE_YEAR.isValid(new Field("iyr", "2015"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.ISSUE_YEAR.isValid(new Field("iyr", "2020"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.ISSUE_YEAR.isValid(new Field("iyr", "2021"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.ISSUE_YEAR.isValid(new Field("iyr", "2100"))).isEqualTo(Validation.INVALID);
			}
			@Test
			void expiration_year_is_valid_when_between_2020_and_2030() {
				assertThat(FieldRules.EXPIRATION_YEAR.isValid(new Field("eyr", "1900"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.EXPIRATION_YEAR.isValid(new Field("eyr", "2019"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.EXPIRATION_YEAR.isValid(new Field("eyr", "2020"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.EXPIRATION_YEAR.isValid(new Field("eyr", "2025"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.EXPIRATION_YEAR.isValid(new Field("eyr", "2030"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.EXPIRATION_YEAR.isValid(new Field("eyr", "2031"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.EXPIRATION_YEAR.isValid(new Field("eyr", "2100"))).isEqualTo(Validation.INVALID);
			}
			@Test
			void height_is_valid_when_centimeters_between_150_and_193() {
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "100cm"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "149cm"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "150cm"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "180cm"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "193cm"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "194cm"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "200cm"))).isEqualTo(Validation.INVALID);
			}
			@Test
			void height_is_valid_when_inches_between_59_and_76() {
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "50in"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "58in"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "59in"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "70in"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "76in"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "77in"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "100in"))).isEqualTo(Validation.INVALID);
			}
			@Test
			void height_is_invalid_when_neither_centimeters_nor_inches() {
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "10"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "59"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "150"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.HEIGHT.isValid(new Field("eyr", "1000"))).isEqualTo(Validation.INVALID);
			}
			@Test
			void hair_color_is_valid_when_hexcolor() {
				assertThat(FieldRules.HAIR_COLOR.isValid(new Field("hcl", "#123abc"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.HAIR_COLOR.isValid(new Field("hcl", "#abc123"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.HAIR_COLOR.isValid(new Field("hcl", "#abcdef"))).isEqualTo(Validation.VALID);

				assertThat(FieldRules.HAIR_COLOR.isValid(new Field("hcl", "123abc"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.HAIR_COLOR.isValid(new Field("hcl", "#55555"))).isEqualTo(Validation.INVALID);
				assertThat(FieldRules.HAIR_COLOR.isValid(new Field("hcl", "#66666g"))).isEqualTo(Validation.INVALID);
			}
			@Nested
			class EyeColor {
				@Nested
				class Valid{
					@Test
					void when_amb() {
						assertThat(FieldRules.EYE_COLOR.isValid(new Field("ecl", "amb"))).isEqualTo(Validation.VALID);
					}
					@Test
					void when_blu() {
						assertThat(FieldRules.EYE_COLOR.isValid(new Field("ecl", "blu"))).isEqualTo(Validation.VALID);
					}
					@Test
					void when_brn() {
						assertThat(FieldRules.EYE_COLOR.isValid(new Field("ecl", "brn"))).isEqualTo(Validation.VALID);
					}
					@Test
					void when_gry() {
						assertThat(FieldRules.EYE_COLOR.isValid(new Field("ecl", "gry"))).isEqualTo(Validation.VALID);
					}
					@Test
					void when_grn() {
						assertThat(FieldRules.EYE_COLOR.isValid(new Field("ecl", "grn"))).isEqualTo(Validation.VALID);
					}
					@Test
					void when_hzl() {
						assertThat(FieldRules.EYE_COLOR.isValid(new Field("ecl", "hzl"))).isEqualTo(Validation.VALID);
					}
					@Test
					void when_oth() {
						assertThat(FieldRules.EYE_COLOR.isValid(new Field("ecl", "oth"))).isEqualTo(Validation.VALID);
					}
				}
				@Nested
				class Invalid{
					@Test
					void when_anything_else() {
						assertThat(FieldRules.EYE_COLOR.isValid(new Field("ecl", "foo"))).isEqualTo(Validation.INVALID);
					}
					@Test
					void when_ends_with_correct_but_not_exact_match() {
						assertThat(FieldRules.EYE_COLOR.isValid(new Field("ecl", "foo_oth"))).isEqualTo(Validation.INVALID);
					}
					@Test
					void when_begins_with_correct_but_not_exact_match() {
						assertThat(FieldRules.EYE_COLOR.isValid(new Field("ecl", "oth_foo"))).isEqualTo(Validation.INVALID);
					}
				}
			}
			@Test
			void passport_id_is_valid_when_exactly_9_digits() {
				assertThat(FieldRules.PASSPORT_ID.isValid(new Field("pid", "123456789"))).isEqualTo(Validation.VALID);
				assertThat(FieldRules.PASSPORT_ID.isValid(new Field("pid", "999999999"))).isEqualTo(Validation.VALID);
			}
			@Test
			void passport_id_is_invalid_when_8_digits() {
				assertThat(FieldRules.PASSPORT_ID.isValid(new Field("pid", "12345678"))).isEqualTo(Validation.INVALID);
			}
			@Test
			void passport_id_is_invalid_when_10_digits() {
				assertThat(FieldRules.PASSPORT_ID.isValid(new Field("pid", "1234567890"))).isEqualTo(Validation.INVALID);
			}
		}
	}
}
