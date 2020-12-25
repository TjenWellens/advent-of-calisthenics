package eu.tjenwellens.adventofcalisthenics.day1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpenseReportShould {
	final ExpenseReportFixer expenseReportFixer = new ExpenseReportFixer();

	private ExpenseReport report(String... expenses) {
		List<Expense> expensesList = new LinkedList<>();
		for (String expense : expenses) {
			expensesList.add(new Expense(expense));
		}
		return new ExpenseReport(expensesList);
	}

	@Test
	void find_two_entries_that_sum_to_2020_and_multiply_them() {
		assertThat(expenseReportFixer.findAnswer(report(
				"1721",
				"979",
				"366",
				"299",
				"675",
				"1456"
		)))
				.isEqualTo(new ExpenseMultiplication(514579));
	}

	@Test
	void find_three_entries_that_sum_to_2020_and_multiply_them() {
		assertThat(expenseReportFixer.findThreeMultiplied(report(
				"1721",
				"979",
				"366",
				"299",
				"675",
				"1456"
		)))
				.isEqualTo(new ExpenseMultiplication(241861950));
	}

	@Nested
	@DisplayName("when find 2 numbers summing to 2020")
	class _3Numbers {
		@Test
		void multiply_given_1_times_1_times_2018() {
			assertThat(expenseReportFixer.findThreeMultiplied(report(
					"2018",
					"1",
					"1"
			)))
					.isEqualTo(new ExpenseMultiplication(2018));
		}
	}

	@Nested
	@DisplayName("when find 2 numbers summing to 2020")
	class _2Numbers {
		@Nested
		@DisplayName("multiply the result")
		class Multiply {
			@Test
			void given_1_times_2019() {
				assertThat(expenseReportFixer.findAnswer(report(
						"2019",
						"1"
				)))
						.isEqualTo(new ExpenseMultiplication(2019));
			}

			@Test
			void given_2_times_2018() {
				assertThat(expenseReportFixer.findAnswer(report(
						"2018",
						"2"
				)))
						.isEqualTo(new ExpenseMultiplication(2018 * 2));
			}
		}

		@Nested
		@DisplayName("find entries summing to 2020")
		class FindSumTo2020 {
			@Test
			void given_2019_and_1() {
				assertThat(expenseReportFixer.findAnswer(report(
						"2019",
						"1"
				)))
						.isEqualTo(new ExpenseMultiplication(2019));
			}

			@Test
			void given_2019_and_3_and_1() {
				assertThat(expenseReportFixer.findAnswer(report(
						"2019",
						"3",
						"1"
				)))
						.isEqualTo(new ExpenseMultiplication(2019));
			}

			@Test
			void given_2019_and_1_and_3() {
				assertThat(expenseReportFixer.findAnswer(report(
						"2019",
						"1",
						"3"
				)))
						.isEqualTo(new ExpenseMultiplication(2019));
			}

			@Test
			void given_2019_and_3_and_2_and_1() {
				assertThat(expenseReportFixer.findAnswer(report(
						"2019",
						"3",
						"2",
						"1"
				)))
						.isEqualTo(new ExpenseMultiplication(2019));
			}
		}

		@Disabled
		@Test
		void part1_input() throws IOException {
			final Path path = Paths.get("src", "test", "resources", "day-1-input.txt");
			final ExpenseReport report = new ExpenseReport(Files.lines(path)
					.map(Expense::new)
					.collect(Collectors.toList()));
			assertThat(expenseReportFixer.findAnswer(report))
					.isEqualTo(new ExpenseMultiplication(889779));
		}
	}
}
