package eu.tjenwellens.adventofcalisthenics.day1.expense;

import eu.tjenwellens.adventofcalisthenics.day1.expense.multiply.MultiplyableExpense;
import eu.tjenwellens.adventofcalisthenics.day1.expense.sum.SumableExpense;
import lombok.Value;

@Value
public class Expense implements MultiplyableExpense, SumableExpense {
	String expense;

	@Override
	public int getValueForMultiplication() {
		return Integer.parseInt(expense);
	}

	@Override
	public int getValueForSum() {
		return Integer.parseInt(expense);
	}
}
