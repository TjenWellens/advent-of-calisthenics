package eu.tjenwellens.adventofcalisthenics.day1.report;

import eu.tjenwellens.adventofcalisthenics.day1.Expenses;
import eu.tjenwellens.adventofcalisthenics.day1.expense.Expense;
import lombok.Value;

import java.util.LinkedList;
import java.util.List;

@Value
class ExpensesPermutations {
	List<Expense> expenses;

	private List<Expenses> getAllSingles() {
		final List<Expenses> result = new LinkedList<>();
		for (Expense first : expenses) {
			result.add(new ExpensesCollection(List.of(first)));
		}
		return result;
	}

	public List<Expenses> getAllPairs() {
		return getAllPermutations(getAllSingles());
	}

	private List<Expenses> getAllPermutations(List<Expenses> allSingles) {
		final List<Expenses> result = new LinkedList<>();
		for (Expenses pair : allSingles) {
			result.addAll(permutationsFor(pair));
		}
		return result;
	}

	private List<Expenses> permutationsFor(Expenses current) {
		final List<Expenses> permutations = new LinkedList<>();
		for (Expense extra : expenses) {
			if (current.containsExactExpenseObject(extra)) continue;
			permutations.add(current.add(extra));
		}
		return permutations;
	}

	public List<Expenses> getAllTriples() {
		return getAllPermutations(getAllPairs());
	}
}
