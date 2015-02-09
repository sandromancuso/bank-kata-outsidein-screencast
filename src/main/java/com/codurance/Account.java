package com.codurance;

public class Account {

	private Clock clock;
	private Transactions transactions;

	public Account(Clock clock, Transactions transactions) {
		this.clock = clock;
		this.transactions = transactions;
	}

	public void deposit(int amount) {
		Transaction deposit = new Transaction(clock.dateAsString(), amount);
		transactions.add(deposit);
	}

	public void withdraw(int amount) {


	}

	public void printStatement() {


	}

}
