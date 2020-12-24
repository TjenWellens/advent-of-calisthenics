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
		return first.add(second).equals(new ExpenseSum(2020));
	}
}
