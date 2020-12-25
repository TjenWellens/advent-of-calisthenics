package eu.tjenwellens.adventofcalisthenics.day1.expense.multiply;

import lombok.Value;

@Value
public class ExpenseMultiplication implements MultiplyableExpense{
	int answer;

	@Override
	public int getValueForMultiplication() {
		return answer;
	}
}
