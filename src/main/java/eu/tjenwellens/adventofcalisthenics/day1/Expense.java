package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

@Value
public class Expense {
	String expense;

	public ExpenseMultiplication multiply(Expense otherExpense) {
		final int me = Integer.parseInt(expense);
		final int other = Integer.parseInt(otherExpense.expense);
		return new ExpenseMultiplication(me * other);
	}

	public ExpenseSum add(Expense otherExpense) {
		final int me = Integer.parseInt(expense);
		final int other = Integer.parseInt(otherExpense.expense);
		return new ExpenseSum(me + other);
	}

	public ExpenseMultiplication multiply(ExpenseMultiplication multiply) {
		final int me = Integer.parseInt(expense);
		return new ExpenseMultiplication(me * multiply.getAnswer());
	}
}
