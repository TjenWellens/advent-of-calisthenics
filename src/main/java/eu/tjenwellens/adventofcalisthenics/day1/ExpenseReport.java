package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

import java.util.List;

@Value
public class ExpenseReport {
	List<Expense> expenses;

	public List<Expense> find2ExpensesSumming2020() {
		return expenses;
	}
}
