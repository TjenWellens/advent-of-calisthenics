package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

@Value
public class ExpenseTriple {
	Expense first;
	Expense second;
	Expense third;

	public ExpenseMultiplication multiply() {
		int _2018 = Integer.parseInt(first.getExpense());
		return new ExpenseMultiplication(_2018);
	}
}
