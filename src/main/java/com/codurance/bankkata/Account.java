package com.codurance.bankkata;

public class Account {

	private Clock clock;
	private Transactions transactions;

	public Account(Clock clock, Transactions transactions) {
		this.clock = clock;
		this.transactions = transactions;
	}

	public void deposit(int amount) {
		Transaction deposit = new Transaction(amount, clock.timeAsString());
		transactions.add(deposit);
	}

	public void withdraw(int amount) {
		Transaction withdrawal = new Transaction(-amount, clock.timeAsString());
		transactions.add(withdrawal);
	}

	public void printStatement() {

	}
}
