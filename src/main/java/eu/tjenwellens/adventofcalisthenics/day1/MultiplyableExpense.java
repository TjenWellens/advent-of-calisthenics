package eu.tjenwellens.adventofcalisthenics.day1;

public interface MultiplyableExpense {
	default ExpenseMultiplication multiply(MultiplyableExpense other) {
		return new ExpenseMultiplication(getValueForMultiplication() * other.getValueForMultiplication());
	}

	int getValueForMultiplication();
}
