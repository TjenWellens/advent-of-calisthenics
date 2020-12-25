package eu.tjenwellens.adventofcalisthenics.day1;


public class ExpenseReportFixer {
	public ExpenseMultiplication findAnswer(ExpenseReport expenseReport) {
		final ExpensePair expensesSumming2020 = expenseReport.find2ExpensesSumming2020();
		return expensesSumming2020.multiply();
	}

	public ExpenseMultiplication findThreeMultiplied(ExpenseReport report) {
		int _2018 = Integer.parseInt(report.getExpenses().get(0).getExpense());
		return new ExpenseMultiplication(_2018);
	}
}
