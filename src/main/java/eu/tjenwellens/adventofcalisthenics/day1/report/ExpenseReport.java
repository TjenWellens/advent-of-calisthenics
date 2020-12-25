package eu.tjenwellens.adventofcalisthenics.day1.report;

import eu.tjenwellens.adventofcalisthenics.day1.expense.Expense;
import lombok.Value;

import java.util.List;

@Value
public class ExpenseReport {
	List<Expense> expenses;

	public ExpensePair find2ExpensesSumming2020() {
		for (ExpensePair pair : new ExpensePairPermutations(expenses).getAllPairs()) {
			if (pair.sumIs2020()) {
				return pair;
			}
		}
		throw new RuntimeException("Can't find a pair summing to 2020");
	}

	public ExpenseTriple find3ExpensesSumming2020() {
		for (ExpenseTriple triple : new ExpenseTriplePermutations(expenses).getAllTriples()) {
			if (triple.sumIs2020()) {
				return triple;
			}
		}
		throw new RuntimeException("Can't find a pair summing to 2020");
	}

}
