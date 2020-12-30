package eu.tjenwellens.adventofcalisthenics.day1.report;

import eu.tjenwellens.adventofcalisthenics.day1.Expenses;
import eu.tjenwellens.adventofcalisthenics.day1.expense.Expense;
import eu.tjenwellens.adventofcalisthenics.day1.expense.multiply.ExpenseMultiplication;
import eu.tjenwellens.adventofcalisthenics.day1.expense.sum.ExpenseSum;
import lombok.Value;

@Value
public class ExpenseTriple implements Expenses {
	ExpensePair pair;
	Expense third;

	public ExpenseMultiplication multiply() {
		return third.multiply(pair.multiply());
	}

	public ExpenseSum sum() {
		return pair.sum().sum(third);
	}

	public boolean containsExactExpenseObject(Expense other) {
		return other == third || pair.containsExactExpenseObject(other);
	}

	@Override
	public Expenses add(Expense expense) {
		throw new UnsupportedOperationException();
	}
}
