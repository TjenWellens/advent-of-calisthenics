package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

@Value
public class ExpenseTriple {
	ExpensePair pair;
	Expense third;

	public ExpenseMultiplication multiply() {
		return third.multiply(pair.multiply());
	}

	public boolean sumIs2020() {
		final Expense third = getThird();
		final ExpenseSum sum = pair.sum();
		final ExpenseSum _2020 = new ExpenseSum(2020);
		return third.sum(sum).equals(_2020);
	}
}
