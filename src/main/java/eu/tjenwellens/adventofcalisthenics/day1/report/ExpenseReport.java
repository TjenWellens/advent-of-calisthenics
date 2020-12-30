package eu.tjenwellens.adventofcalisthenics.day1.report;

import eu.tjenwellens.adventofcalisthenics.day1.Expenses;
import eu.tjenwellens.adventofcalisthenics.day1.expense.Expense;
import lombok.Value;

import java.util.List;

@Value
public class ExpenseReport {
	List<Expense> expenses;

	public Expenses find2ExpensesSumming2020() {
		for (Expenses pair : new ExpensePairPermutations(expenses).getAllPairs()) {
			if (pair.sumIs2020()) {
				return pair;
			}
		}
		throw new RuntimeException("Can't find a pair summing to 2020");
	}

	public Expenses find3ExpensesSumming2020() {
		for (Expenses triple : new ExpenseTriplePermutations(expenses).getAllTriples()) {
			if (triple.sumIs2020()) {
				return triple;
			}
		}
		throw new RuntimeException("Can't find a triple summing to 2020");
	}

}
