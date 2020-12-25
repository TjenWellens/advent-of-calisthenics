package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

@Value
public class ExpensePair {
	Expense first;
	Expense second;

	public ExpenseMultiplication multiply() {
		return first.multiply(second);
	}

	public boolean sumIs2020() {
		final ExpenseSum sum = first.add(second);
		final ExpenseSum _2020 = new ExpenseSum(2020);
		return sum.equals(_2020);
	}
}
