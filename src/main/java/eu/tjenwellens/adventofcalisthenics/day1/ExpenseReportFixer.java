package eu.tjenwellens.adventofcalisthenics.day1;


import java.util.List;

public class ExpenseReportFixer {
	public ExpenseReportAnswer findAnswer(ExpenseReport expenseReport) {
		final ExpensePair expensesSumming2020 = expenseReport.find2ExpensesSumming2020();
		final String expense = expensesSumming2020.getFirst().getExpense();
		return new ExpenseReportAnswer(Integer.parseInt(expense));
	}
}
