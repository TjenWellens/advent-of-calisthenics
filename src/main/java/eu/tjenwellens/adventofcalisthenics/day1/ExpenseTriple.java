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
		return getPair().getFirst().getValueForMultiplication() +
				getPair().getSecond().getValueForMultiplication() +
				getThird().getValueForMultiplication() == 2020;
	}
}
