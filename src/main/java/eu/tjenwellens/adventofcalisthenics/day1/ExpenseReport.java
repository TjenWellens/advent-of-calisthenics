package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Value
public class ExpenseReport {
	List<Expense> expenses;

	public ExpensePair find2ExpensesSumming2020() {
		for (ExpensePair pair : getAllPairs()) {
			if (pair.sumIs2020()) {
				return pair;
			}
		}
		throw new RuntimeException("Can't find a pair summing to 2020");
	}

	private List<ExpensePair> getAllPairs() {
		final List<ExpensePair> result = new LinkedList<>();
		for (Expense first : expenses) {
			for (Expense second : expenses) {
				final ExpensePair pair = new ExpensePair(first, second);
				result.add(pair);
			}
		}
		return result;
	}
}
