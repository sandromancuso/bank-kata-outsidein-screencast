package com.codurance.bankkata;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.google.common.collect.Lists.reverse;
import static java.util.stream.Collectors.toList;

public class StatementPrinter {

	public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";

	private Console console;

	public StatementPrinter(Console console) {
		this.console = console;
	}

	public void print(List<Transaction> transactions) {
		printStatementHeader();
		printStatementLines(transactions);
	}

	private void printStatementHeader() {
		console.printLine(STATEMENT_HEADER);
	}

	private void printStatementLines(List<Transaction> transactions) {
		List<String> statementLines = statementLinesFor(transactions);
		reverse(statementLines).forEach(console::printLine);
	}

	private List<String> statementLinesFor(List<Transaction> transactions) {
		final AtomicInteger runningBalance = new AtomicInteger(0);
		return transactions.stream()
							.map(t -> statementLine(runningBalance, t))
							.collect(toList());
	}

	private String statementLine(AtomicInteger runningBalance, Transaction t) {
		return
			t.date() +
			" | " +
			formatWithTwoDecimalDigits(t.amount()) +
			" | " +
			formatWithTwoDecimalDigits(runningBalance.addAndGet(t.amount()));
	}

	private String formatWithTwoDecimalDigits(int amount) {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		return decimalFormat.format(amount);
	}
}
