package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

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

	public ExpenseTriple find3ExpensesSumming2020() {
		for (ExpenseTriple triple : getAllTriples()) {
			if (triple.sumIs2020()) {
				return triple;
			}
		}
		throw new RuntimeException("Can't find a pair summing to 2020");
	}

	public List<ExpenseTriple> getAllTriples() {
		if (expenses.size() == 3) {
			return List.of(getFirstTriple());
		}
		return getAllTriplesWhenLargerThan3();
	}

	private List<ExpenseTriple> getAllTriplesWhenLargerThan3() {
		return List.of(
				getFirstTriple(),
				getYetAnotherTriple(),
				getAnotherTriple()
		);
	}

	private ExpenseTriple getAnotherTriple() {
		return new ExpenseTriple(new ExpensePair(expenses.get(0), expenses.get(2)), expenses.get(3));
	}

	private ExpenseTriple getYetAnotherTriple() {
		return new ExpenseTriple(new ExpensePair(expenses.get(0), expenses.get(1)), expenses.get(3));
	}

	private ExpenseTriple getFirstTriple() {
		return new ExpenseTriple(new ExpensePair(expenses.get(0), expenses.get(1)), expenses.get(2));
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
