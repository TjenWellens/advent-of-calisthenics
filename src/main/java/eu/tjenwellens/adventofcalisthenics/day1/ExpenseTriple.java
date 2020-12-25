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
		return third.sum(sum).getSum() == 2020;
	}
}
