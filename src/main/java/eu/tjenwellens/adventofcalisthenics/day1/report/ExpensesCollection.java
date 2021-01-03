package eu.tjenwellens.adventofcalisthenics.day1.report;

import eu.tjenwellens.adventofcalisthenics.day1.Expenses;
import eu.tjenwellens.adventofcalisthenics.day1.expense.Expense;
import eu.tjenwellens.adventofcalisthenics.day1.expense.multiply.ExpenseMultiplication;
import eu.tjenwellens.adventofcalisthenics.day1.expense.sum.ExpenseSum;
import lombok.Value;

import java.util.Collection;
import java.util.LinkedList;

@Value
public class ExpensesCollection implements Expenses {
	Collection<Expense> expenses;

	@Override
	public ExpenseMultiplication multiply() {
		ExpenseMultiplication result = new ExpenseMultiplication(1);
		for (Expense expense : expenses) {
			result = expense.multiply(result);
		}
		return result;
	}

	@Override
	public ExpenseSum sum() {
		ExpenseSum result = new ExpenseSum(0);
		for (Expense expense : expenses) {
			result = expense.sum(result);
		}
		return result;
	}

	@Override
	public boolean containsExactExpenseObject(Expense other) {
		for (Expense expense : expenses) {
			if (other == expense) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Expenses add(Expense expense) {
		LinkedList<Expense> list = new LinkedList<>(expenses);
		list.add(expense);
		return new ExpensesCollection(list);
	}
}
