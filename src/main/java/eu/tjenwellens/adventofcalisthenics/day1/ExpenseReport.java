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
		if (sumIs2020(getFirstTriple())) {
			return getFirstTriple();
		}
		if (sumIs2020(getYetAnotherTriple())) {
			return getYetAnotherTriple();
		}
		return getAnotherTriple();
	}

	public boolean sumIs2020(ExpenseTriple triple) {
		return triple.getPair().getFirst().getValueForMultiplication() +
				triple.getPair().getSecond().getValueForMultiplication() +
				triple.getThird().getValueForMultiplication() == 2020;
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
