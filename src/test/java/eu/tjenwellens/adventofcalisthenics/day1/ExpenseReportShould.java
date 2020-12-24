package eu.tjenwellens.adventofcalisthenics.day1;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpenseReportShould {
	private ExpenseReport report(String... expenses) {
		List<Expense> expensesList = new LinkedList<>();
		for (String expense : expenses) {
			expensesList.add(new Expense(expense));
		}
		return new ExpenseReport(expensesList);
	}

	@Test
	void find_two_entries_that_sum_to_2020_and_multiply_them() {
		final ExpenseReportFixer expenseReportFixer = new ExpenseReportFixer();
		final ExpenseReport expenseReport = report(
				"1721",
				"979",
				"366",
				"299",
				"675",
				"1456"
		);
		assertThat(expenseReportFixer.findAnswer(expenseReport))
				.isEqualTo(new ExpenseMultiplication(514579));
	}

	@Test
	void find_2019_and_1_and_multiply_them() {
		final ExpenseReportFixer expenseReportFixer = new ExpenseReportFixer();
		final ExpenseReport expenseReport = report(
				"2019",
				"1"
		);
		assertThat(expenseReportFixer.findAnswer(expenseReport))
				.isEqualTo(new ExpenseMultiplication(2019));
	}

	@Test
	void findAnswer_2018_and_2_returns_multiplied() {
		final ExpenseReportFixer expenseReportFixer = new ExpenseReportFixer();
		final ExpenseReport expenseReport = report(
				"2018",
				"2"
		);
		assertThat(expenseReportFixer.findAnswer(expenseReport))
				.isEqualTo(new ExpenseMultiplication(2018 * 2));
	}

	@Test
	void find_2019_and_3_and_1_return_2019() {
		final ExpenseReportFixer expenseReportFixer = new ExpenseReportFixer();
		final ExpenseReport expenseReport = report(
				"2019",
				"3",
				"1"
		);
		assertThat(expenseReportFixer.findAnswer(expenseReport))
				.isEqualTo(new ExpenseMultiplication(2019));
	}

	@Test
	void find_2019_and_1_and_3_return_2019() {
		final ExpenseReportFixer expenseReportFixer = new ExpenseReportFixer();
		final ExpenseReport expenseReport = report(
				"2019",
				"1",
				"3"
		);
		assertThat(expenseReportFixer.findAnswer(expenseReport))
				.isEqualTo(new ExpenseMultiplication(2019));
	}

	@Test
	void find_2019_and_3_and_2_and_1_return_2019() {
		final ExpenseReportFixer expenseReportFixer = new ExpenseReportFixer();
		final ExpenseReport expenseReport = report(
				"2019",
				"3",
				"2",
				"1"
		);
		assertThat(expenseReportFixer.findAnswer(expenseReport))
				.isEqualTo(new ExpenseMultiplication(2019));
	}
}
