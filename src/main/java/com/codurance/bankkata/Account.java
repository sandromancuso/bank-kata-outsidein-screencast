package com.codurance.bankkata;

public class Account {

	private Clock clock;
	private Transactions transactions;

	public Account(Clock clock, Transactions transactions) {
		this.clock = clock;
		this.transactions = transactions;
	}

	public void deposit(int amount) {
		Transaction transaction = new Transaction(amount, clock.timeAsString());
		transactions.add(transaction);
	}

	public void printStatement() {

	}

	public void withdraw(int amount) {

	}
}
