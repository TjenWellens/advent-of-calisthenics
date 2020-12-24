package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

import java.util.List;

@Value
public class ExpenseReport {
	List<Expense> expenses;

	public ExpensePair find2ExpensesSumming2020() {
		final Expense firstExpense = expenses.get(0);
		final Expense second = expenses.get(1);
		final ExpensePair firstPair = new ExpensePair(firstExpense, second);
		if (firstPair.sumIs2020()) {
			return firstPair;
		}
		return new ExpensePair(firstExpense, expenses.get(2));
	}

}
