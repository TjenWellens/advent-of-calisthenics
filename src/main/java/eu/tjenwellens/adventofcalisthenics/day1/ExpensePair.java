package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

@Value
public class ExpensePair {
	Expense first;
	Expense second;

	public ExpenseReportAnswer multiply() {
		return new ExpenseReportAnswer(Integer.parseInt(first.getExpense()));
	}
}
