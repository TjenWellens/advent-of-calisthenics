package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

import java.util.List;

@Value
public class ExpenseReport {
	List<Expense> expenses;

	public ExpensePair find2ExpensesSumming2020() {
		if (expenses.size() > 2) {
			return new ExpensePair(expenses.get(0), expenses.get(2));
		}
		return new ExpensePair(expenses.get(0), expenses.get(1));
	}
}
