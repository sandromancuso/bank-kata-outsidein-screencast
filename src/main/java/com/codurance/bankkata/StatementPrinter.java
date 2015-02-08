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
		console.printLine(STATEMENT_HEADER);

		final AtomicInteger runningBalance = new AtomicInteger(0);
		List<String> statementLines = transactions
											.stream()
											.map(t -> statementLine(runningBalance, t))
											.collect(toList());
		reverse(statementLines).forEach(console::printLine);

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
