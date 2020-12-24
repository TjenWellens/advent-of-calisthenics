package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

import java.util.List;

@Value
public class ExpenseReport {
	List<Expense> expenses;

	public ExpensePair find2ExpensesSumming2020() {
		if (sumTo2020(expenses.get(0), expenses.get(1))) {
			return new ExpensePair(expenses.get(0), expenses.get(1));
		}
		return new ExpensePair(expenses.get(0), expenses.get(2));
	}

	private boolean sumTo2020(Expense a, Expense b) {
		return Integer.parseInt(a.getExpense()) + Integer.parseInt(b.getExpense()) == 2020;
	}
}
