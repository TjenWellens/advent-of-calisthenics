package eu.tjenwellens.adventofcalisthenics.day1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpenseReportShould {
	@Test
	void find_two_entries_that_sum_to_2020_and_multiply_them() {
		final ExpenseReportFixer expenseReportFixer = new ExpenseReportFixer();
		final ExpenseReport expenseReport = new ExpenseReport(Arrays.asList(
				new Expense("1721"),
				new Expense("979"),
				new Expense("366"),
				new Expense("299"),
				new Expense("675"),
				new Expense("1456")
		));
		assertThat(expenseReportFixer.findAnswer(expenseReport))
				.isEqualTo(new ExpenseMultiplication(514579));
	}

	@Test
	void find_2019_and_1_and_multiply_them() {
		final ExpenseReportFixer expenseReportFixer = new ExpenseReportFixer();
		final ExpenseReport expenseReport = new ExpenseReport(Arrays.asList(
				new Expense("2019"),
				new Expense("1")
		));
		assertThat(expenseReportFixer.findAnswer(expenseReport))
				.isEqualTo(new ExpenseMultiplication(2019));
	}

	@Test
	void findAnswer_2018_and_2_returns_multiplied() {
		final ExpenseReportFixer expenseReportFixer = new ExpenseReportFixer();
		final ExpenseReport expenseReport = new ExpenseReport(Arrays.asList(
				new Expense("2018"),
				new Expense("2")
		));
		assertThat(expenseReportFixer.findAnswer(expenseReport))
				.isEqualTo(new ExpenseMultiplication(2018 * 2));
	}
}
