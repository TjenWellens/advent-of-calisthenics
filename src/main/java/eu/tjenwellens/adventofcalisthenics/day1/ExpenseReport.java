package eu.tjenwellens.adventofcalisthenics.day1;

import lombok.Value;

import java.util.List;

@Value
public class ExpenseReport {
	List<Expense> expenses;

	public ExpensePair find2ExpensesSumming2020() {
		final ExpensePair firstPair = getFirstPair();
		if (firstPair.sumIs2020()) {
			return firstPair;
		}
		final ExpensePair anotherPair = getAnotherPair();
		if(anotherPair.sumIs2020()){
			return anotherPair;
		}
		return getYetAnotherPair();
	}

	private ExpensePair getAnotherPair() {
		final Expense firstExpense = expenses.get(0);
		final Expense third = expenses.get(2);
		return new ExpensePair(firstExpense, third);
	}

	private ExpensePair getYetAnotherPair() {
		final Expense firstExpense = expenses.get(0);
		final Expense fourth = expenses.get(3);
		return new ExpensePair(firstExpense, fourth);
	}

	private ExpensePair getFirstPair() {
		final Expense firstExpense = expenses.get(0);
		final Expense second = expenses.get(1);
		return new ExpensePair(firstExpense, second);
	}

}
