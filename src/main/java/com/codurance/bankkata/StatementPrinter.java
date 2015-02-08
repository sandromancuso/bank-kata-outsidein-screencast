package com.codurance.bankkata;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatementPrinter {

	public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";

	private Console console;

	public StatementPrinter(Console console) {
		this.console = console;
	}

	public void print(List<Transaction> transactions) {
		console.printLine(STATEMENT_HEADER);

		List<Transaction> transactionsToBePrinted = new ArrayList<>(transactions);

		List<String> statementLines = new ArrayList<>();
		int runningBalance = 0;
		for (Transaction transaction : transactionsToBePrinted) {
			runningBalance += transaction.amount();
			statementLines.add(transaction.date() +
								" | " +
								formatWithTwoDecimalDigits(transaction.amount()) +
								" | " +
								formatWithTwoDecimalDigits(runningBalance));
		}
		Collections.reverse(statementLines);

		statementLines.forEach(l -> {
			System.out.println(l);
			console.printLine(l);
		});

	}

	private String formatWithTwoDecimalDigits(int amount) {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		return decimalFormat.format(amount);
	}
}
