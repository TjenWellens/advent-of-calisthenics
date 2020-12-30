package eu.tjenwellens.adventofcalisthenics.day1;

import eu.tjenwellens.adventofcalisthenics.day1.expense.Expense;
import eu.tjenwellens.adventofcalisthenics.day1.expense.multiply.ExpenseMultiplication;
import eu.tjenwellens.adventofcalisthenics.day1.expense.sum.ExpenseSum;

public interface Expenses {
	ExpenseMultiplication multiply();

	default boolean sumIs2020() {
		final ExpenseSum _2020 = new ExpenseSum(2020);
		return sum().equals(_2020);
	}

	ExpenseSum sum();

	boolean containsExactExpenseObject(Expense other);

	Expenses add(Expense expense);
}
