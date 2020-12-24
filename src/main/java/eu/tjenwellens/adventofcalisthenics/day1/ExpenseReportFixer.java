package eu.tjenwellens.adventofcalisthenics.day1;


import java.util.List;

public class ExpenseReportFixer {
	public ExpenseReportAnswer findAnswer(ExpenseReport expenseReport) {
		final ExpensePair expensesSumming2020 = expenseReport.find2ExpensesSumming2020();
		return expensesSumming2020.multiply();
	}
}
