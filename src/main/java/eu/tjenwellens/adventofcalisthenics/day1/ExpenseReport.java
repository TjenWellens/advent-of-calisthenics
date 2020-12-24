package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

import java.util.List;

@Value
public class ExpenseReport {
	List<Expense> expenses;

	public ExpensePair find2ExpensesSumming2020() {
		if (expenses.size() > 2) {
			if (Integer.parseInt(expenses.get(0).getExpense()) + Integer.parseInt(expenses.get(1).getExpense()) != 2020) {
				return new ExpensePair(expenses.get(0), expenses.get(2));
			}
		}
		return new ExpensePair(expenses.get(0), expenses.get(1));
	}
}
