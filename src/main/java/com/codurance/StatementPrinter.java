package com.codurance;

import com.codurance.bankkata.Console;

import java.util.List;

public class StatementPrinter {

	public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";

	private Console console;

	public StatementPrinter(Console console) {
		this.console = console;
	}

	public void print(List<Transaction> transactionList) {
		console.printLine(STATEMENT_HEADER);
	}
}
