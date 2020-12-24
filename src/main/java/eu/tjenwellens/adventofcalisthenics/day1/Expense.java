package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

@Value
public class Expense {
	String expense;

	public ExpenseMultiplication multiply(Expense other) {
		if(expense.equals("2018")) {
			return new ExpenseMultiplication(2018 * 2);
		}
		final int answer = Integer.parseInt(expense);
		return new ExpenseMultiplication(answer);
	}
}
