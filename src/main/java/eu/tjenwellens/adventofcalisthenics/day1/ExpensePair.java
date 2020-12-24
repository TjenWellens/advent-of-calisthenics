package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

@Value
public class ExpensePair {
	Expense first;
	Expense second;

	public ExpenseMultiplication multiply() {
		return first.multiply(second);
	}
}
