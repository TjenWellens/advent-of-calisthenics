package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

import java.util.LinkedList;
import java.util.List;

@Value
class ExpenseTriplePermutations {
	List<Expense> expenses;

	public List<ExpenseTriple> getAllTriples() {
		final List<ExpenseTriple> result = new LinkedList<>();
		for (ExpensePair pair : new ExpensePairPermutations(expenses).getAllPairs()) {
			result.addAll(permutationsFor(pair));
		}
		return result;
	}

	private List<ExpenseTriple> permutationsFor(ExpensePair pair) {
		final List<ExpenseTriple> permutations = new LinkedList<>();
		for (Expense third : expenses) {
			if (pair.containsExactExpenseObject(third)) continue;
			permutations.add(new ExpenseTriple(pair, third));
		}
		return permutations;
	}
}
