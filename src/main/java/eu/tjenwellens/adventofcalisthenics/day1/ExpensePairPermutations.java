package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

import java.util.LinkedList;
import java.util.List;

@Value
class ExpensePairPermutations {
	List<Expense> expenses;

	public List<ExpensePair> getAllPairs() {
		final List<ExpensePair> result = new LinkedList<>();
		for (Expense first : expenses) {
			result.addAll(permutationsFor(first));
		}
		return result;
	}

	private List<ExpensePair> permutationsFor(Expense first) {
		final List<ExpensePair> permutations = new LinkedList<>();
		for (Expense second : expenses) {
			if (first == second) continue;
			permutations.add(new ExpensePair(first, second));
		}
		return permutations;
	}
}
