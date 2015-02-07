package com.codurance.bankkata;

public class Account {

	private Transactions transactions;

	public Account(Transactions transactions) {
		this.transactions = transactions;
	}

	public void printStatement() {


	}

	public void deposit(int amount) {
		Transaction transaction = new Transaction(amount, "");
		transactions.add(transaction);
	}

	public void withdraw(int amount) {


	}
}
