package com.codurance;

public class Account {

	private Clock clock;
	private Transactions transactions;
	private StatementPrinter statementPrinter;

	public Account(Clock clock, Transactions transactions, StatementPrinter statementPrinter) {
		this.clock = clock;
		this.transactions = transactions;
		this.statementPrinter = statementPrinter;
	}

	public void deposit(int amount) {
		Transaction deposit = new Transaction(clock.dateAsString(), amount);
		transactions.add(deposit);
	}

	public void withdraw(int amount) {
		Transaction deposit = new Transaction(clock.dateAsString(), -amount);
		transactions.add(deposit);
	}

	public void printStatement() {
		statementPrinter.print(transactions.all());
	}

}
