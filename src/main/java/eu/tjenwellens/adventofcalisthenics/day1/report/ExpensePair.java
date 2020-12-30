package eu.tjenwellens.adventofcalisthenics.day1.report;

import eu.tjenwellens.adventofcalisthenics.day1.Expenses;
import eu.tjenwellens.adventofcalisthenics.day1.expense.Expense;
import eu.tjenwellens.adventofcalisthenics.day1.expense.multiply.ExpenseMultiplication;
import eu.tjenwellens.adventofcalisthenics.day1.expense.sum.ExpenseSum;
import lombok.Value;

@Value
public class ExpensePair implements Expenses {
	Expense first;
	Expense second;

	public ExpenseMultiplication multiply() {
		return first.multiply(second);
	}

	public ExpenseSum sum() {
		return first.sum(second);
	}

	public boolean containsExactExpenseObject(Expense other) {
		return other == first || other == second;
	}

	@Override
	public Expenses add(Expense expense) {
		return new ExpenseTriple(this, expense);
	}
}
