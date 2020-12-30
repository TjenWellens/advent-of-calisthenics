package eu.tjenwellens.adventofcalisthenics.day1.report;

import eu.tjenwellens.adventofcalisthenics.day1.Expenses;
import eu.tjenwellens.adventofcalisthenics.day1.expense.Expense;
import lombok.Value;

import java.util.LinkedList;
import java.util.List;

@Value
class ExpenseTriplePermutations {
	List<Expense> expenses;

	public List<Expenses> getAllTriples() {
		final List<Expenses> result = new LinkedList<>();
		for (Expenses pair : new ExpensePairPermutations(expenses).getAllPairs()) {
			result.addAll(permutationsFor(pair));
		}
		return result;
	}

	private List<Expenses> permutationsFor(Expenses pair) {
		final List<Expenses> permutations = new LinkedList<>();
		for (Expense third : expenses) {
			if (pair.containsExactExpenseObject(third)) continue;
			permutations.add(pair.add(third));
		}
		return permutations;
	}
}
