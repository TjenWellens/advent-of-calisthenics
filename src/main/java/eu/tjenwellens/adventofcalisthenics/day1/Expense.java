package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

@Value
public class Expense {
	String expense;

	public ExpenseMultiplication multiply(Expense other) {
		final int answer = Integer.parseInt(expense);
		return new ExpenseMultiplication(answer);
	}
}
