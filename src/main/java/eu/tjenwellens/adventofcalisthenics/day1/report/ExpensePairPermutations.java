package eu.tjenwellens.adventofcalisthenics.day1.report;

import eu.tjenwellens.adventofcalisthenics.day1.Expenses;
import eu.tjenwellens.adventofcalisthenics.day1.expense.Expense;
import lombok.Value;

import java.util.LinkedList;
import java.util.List;

@Value
class ExpensePairPermutations {
	List<Expense> expenses;

	public List<Expenses> getAllPairs() {
		final List<Expenses> result = new LinkedList<>();
		for (Expense first : expenses) {
			result.addAll(permutationsFor(first));
		}
		return result;
	}

	private List<Expenses> permutationsFor(Expense first) {
		final List<Expenses> permutations = new LinkedList<>();
		for (Expense second : expenses) {
			if (first == second) continue;
			permutations.add(new ExpensesCollection(List.of(first, second)));
		}
		return permutations;
	}
}
