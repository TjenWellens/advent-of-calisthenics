package eu.tjenwellens.adventofcalisthenics.day1;


public class ExpenseReportFixer {
	public ExpenseMultiplication findAnswer(ExpenseReport expenseReport) {
		final ExpensePair expensesSumming2020 = expenseReport.find2ExpensesSumming2020();
		return expensesSumming2020.multiply();
	}

	public ExpenseMultiplication findThreeMultiplied(ExpenseReport report) {
		ExpenseTriple triple = report.find3ExpensesSumming2020();
		return triple.multiply();
	}
}
