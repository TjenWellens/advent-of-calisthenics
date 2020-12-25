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
			result.addAll(permutationsFor(first));
		}
		return result;
	}

	private List<ExpensePair> permutationsFor(Expense first) {
		final List<ExpensePair> permutations = new LinkedList<>();
		for (Expense second : expenses) {
			permutations.add(new ExpensePair(first, second));
		}
		return permutations;
	}
}