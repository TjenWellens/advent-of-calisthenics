package eu.tjenwellens.adventofcalisthenics.day1.report;

import eu.tjenwellens.adventofcalisthenics.day1.expense.Expense;
import eu.tjenwellens.adventofcalisthenics.day1.expense.multiply.ExpenseMultiplication;
import eu.tjenwellens.adventofcalisthenics.day1.expense.sum.ExpenseSum;
import lombok.Value;

@Value
public class ExpenseTriple {
	ExpensePair pair;
	Expense third;

	public ExpenseMultiplication multiply() {
		return third.multiply(pair.multiply());
	}

	public boolean sumIs2020() {
		final ExpenseSum _2020 = new ExpenseSum(2020);
		return sum().equals(_2020);
	}

	public ExpenseSum sum() {
		return pair.sum().sum(third);
	}

	public boolean containsExactExpenseObject(Expense other) {
		return other == third || pair.containsExactExpenseObject(other);
	}
}
