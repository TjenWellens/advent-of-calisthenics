package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

@Value
public class ExpenseTriple {
	Expense first;
	Expense second;
	Expense third;

	public ExpenseMultiplication multiply() {
		return first.multiply(second);
	}
}
