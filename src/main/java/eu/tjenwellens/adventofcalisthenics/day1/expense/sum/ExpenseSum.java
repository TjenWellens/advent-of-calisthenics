package eu.tjenwellens.adventofcalisthenics.day1.expense.sum;

import lombok.Value;

@Value
public class ExpenseSum implements SumableExpense {
	int sum;

	@Override
	public int getValueForSum() {
		return sum;
	}
}
