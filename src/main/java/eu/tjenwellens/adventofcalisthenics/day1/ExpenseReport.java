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
		final List<ExpenseTriple> result = new LinkedList<>();
		for (ExpensePair pair : getAllPairs()) {
			for (Expense third : expenses) {
				if (third == pair.getFirst() || third == pair.getSecond()) continue;
				result.add(new ExpenseTriple(pair, third));
			}
		}
		return result;
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
			if (first == second) continue;
			permutations.add(new ExpensePair(first, second));
		}
		return permutations;
	}
}
