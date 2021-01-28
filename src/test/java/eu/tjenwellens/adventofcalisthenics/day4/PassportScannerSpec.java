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

	@Test
	void a_password_with_all_eight_fields_is_valid() {
		final List<String> lines = Arrays.asList("""
							ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
							byr:1937 iyr:2017 cid:147 hgt:183cm
				""".split("\n"));

		final BatchFile batchFile = new BatchFile(lines);

		assertThat(new PassportScanner().countValidPassports(batchFile)).isEqualTo(new PassportCount(1));
	}

	@DisplayName("a batchfile")
	@Nested
	class ABatchFile {
		@Test
		void can_parse_multiple_single_line_single_field_passwords() {
			final List<String> lines = Arrays.asList("""
								ecl:gry

								pid:860033327

								eyr:2020 hcl:#fffffd

								byr:1937

								iyr:2017

								cid:147

								hgt:183cm
					""".split("\n"));

			final BatchFile batchFile = new BatchFile(lines);

			assertThat(batchFile.parse()).isEqualTo(new Passports(List.of(
					new Passport(List.of(new Field("ecl", "gry"))),
					new Passport(List.of(new Field("pid", "860033327"))),
					new Passport(List.of(new Field("eyr", "2020 hcl:#fffffd"))),
					new Passport(List.of(new Field("byr", "1937"))),
					new Passport(List.of(new Field("iyr", "2017"))),
					new Passport(List.of(new Field("cid", "147"))),
					new Passport(List.of(new Field("hgt", "183cm")))
			)));
		}
	}
}
