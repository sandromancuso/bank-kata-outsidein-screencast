package com.codurance;

import com.codurance.bankkata.Console;

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

	public void print(List<Transaction> transactionList) {
		printHeader();
		printStatementLinesFor(transactionList);
	}

	private void printStatementLinesFor(List<Transaction> transactionList) {
		List<String> statementLines = statementLines(transactionList);
		reverse(statementLines).forEach(console::printLine);
	}

	private List<String> statementLines(List<Transaction> transactionList) {
		AtomicInteger runningBalance = new AtomicInteger(0);
		return transactionList
							.stream()
							.map(transaction -> statementLine(runningBalance, transaction))
							.collect(toList());
	}

	private String statementLine(AtomicInteger runningBalance, Transaction t) {
		return t.date() +
				" | " +
				formatDecimal(t.amount()) +
				" | " +
				formatDecimal(runningBalance.addAndGet(t.amount()));
	}

	private void printHeader() {
		console.printLine(STATEMENT_HEADER);
	}

	private String formatDecimal(int amount) {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		return decimalFormat.format(amount);
	}
}
