package eu.tjenwellens.adventofcalisthenics.day1;


import eu.tjenwellens.adventofcalisthenics.day1.expense.multiply.ExpenseMultiplication;
import eu.tjenwellens.adventofcalisthenics.day1.report.ExpenseReport;

public class ExpenseReportFixer {
	public ExpenseMultiplication findAnswer(ExpenseReport expenseReport) {
		final Expenses expensesSumming2020 = expenseReport.find2ExpensesSumming2020();
		return expensesSumming2020.multiply();
	}

	public ExpenseMultiplication findThreeMultiplied(ExpenseReport report) {
		final Expenses triple = report.find3ExpensesSumming2020();
		return triple.multiply();
	}
}
