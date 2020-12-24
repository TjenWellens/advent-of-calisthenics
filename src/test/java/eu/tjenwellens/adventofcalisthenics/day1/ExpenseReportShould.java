package eu.tjenwellens.adventofcalisthenics.day1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpenseReportShould {
	@Test
	void find_two_entries_that_sum_to_2020_and_multiply_them() {
		assertThat(new ExpenseReport().findAnswer(Arrays.asList(
				"1721",
				"979",
				"366",
				"299",
				"675",
				"1456"
		))).isEqualTo(514579);
	}
}
