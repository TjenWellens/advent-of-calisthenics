package eu.tjenwellens.adventofcalisthenics.day1.expense.sum;

public interface SumableExpense {
	default ExpenseSum sum(SumableExpense other) {
		return new ExpenseSum(getValueForSum() + other.getValueForSum());
	}

	int getValueForSum();
}
