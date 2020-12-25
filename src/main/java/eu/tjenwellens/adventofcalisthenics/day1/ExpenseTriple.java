package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

@Value
public class ExpenseTriple {
	ExpensePair pair;
	Expense third;

	public ExpenseMultiplication multiply() {
		return new ExpenseMultiplication(pair.multiply().getAnswer() * Integer.parseInt(third.getExpense()));
	}
}
