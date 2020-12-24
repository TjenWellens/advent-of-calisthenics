package eu.tjenwellens.adventofcalisthenics.day1;


public class ExpenseReportFixer {
	public ExpenseReportAnswer findAnswer(ExpenseReport expenseReport) {
		final String expense = expenseReport.getExpenses().get(0).getExpense();
		return new ExpenseReportAnswer(Integer.parseInt(expense));
	}
}
