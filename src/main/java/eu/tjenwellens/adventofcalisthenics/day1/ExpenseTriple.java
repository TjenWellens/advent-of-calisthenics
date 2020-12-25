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
		final Expense first = getPair().getFirst();
		final Expense second = getPair().getSecond();
		final Expense third = getThird();
		return first.add(second).getSum() +
				third.getValueForMultiplication() == 2020;
	}
}
