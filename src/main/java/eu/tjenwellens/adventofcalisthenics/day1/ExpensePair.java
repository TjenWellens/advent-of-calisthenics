package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

@Value
public class ExpensePair {
	Expense first;
	Expense second;

	public ExpenseReportAnswer multiply() {
		final String expense = first.getExpense();
		final int answer = Integer.parseInt(expense);
		return new ExpenseReportAnswer(answer);
	}
}
