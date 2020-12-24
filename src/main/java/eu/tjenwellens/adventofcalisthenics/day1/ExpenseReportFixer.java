package eu.tjenwellens.adventofcalisthenics.day1;


import java.util.List;

public class ExpenseReportFixer {
	public ExpenseReportAnswer findAnswer(ExpenseReport expenseReport) {
		final List<Expense> expensesSumming2020 = expenseReport.find2ExpensesSumming2020();
		final String expense = expensesSumming2020.get(0).getExpense();
		return new ExpenseReportAnswer(Integer.parseInt(expense));
	}
}
