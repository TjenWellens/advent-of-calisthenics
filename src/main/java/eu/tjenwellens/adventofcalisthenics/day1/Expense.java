package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

@Value
public class Expense implements MultiplyableExpense {
	String expense;

	@Override
	public int getValueForMultiplication() {
		return Integer.parseInt(expense);
	}

	public ExpenseSum add(Expense otherExpense) {
		final int me = Integer.parseInt(expense);
		final int other = Integer.parseInt(otherExpense.expense);
		return new ExpenseSum(me + other);
	}

	public ExpenseSum add(ExpenseSum sum) {
		final int me = Integer.parseInt(expense);
		return new ExpenseSum(me + sum.getSum());
	}
}
