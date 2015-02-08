package com.codurance.bankkata;

import java.util.ArrayList;
import java.util.List;

public class Transactions {

	private List<Transaction> transactionList;

	public Transactions() {
		this.transactionList = new ArrayList<>();
	}

	public void add(Transaction transaction) {
		transactionList.add(transaction);
	}

	public List<Transaction> all() {
		return transactionList;
	}
}
