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
		for (ExpensePair pair : new ExpensePairPermutations(expenses).getAllPairs()) {
			result.addAll(permutationsFor(pair));
		}
		return result;
	}

	private List<Expenses> permutationsFor(ExpensePair pair) {
		final List<Expenses> permutations = new LinkedList<>();
		for (Expense third : expenses) {
			if (pair.containsExactExpenseObject(third)) continue;
			permutations.add(new ExpenseTriple(pair, third));
		}
		return permutations;
	}
}
