package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

@Value
public class ExpenseSum implements SumableExpense {
	int sum;

	@Override
	public int getValueForSum() {
		return sum;
	}
}
