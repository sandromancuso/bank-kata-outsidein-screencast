package com.codurance.bankkata;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionsShould {

	private Transactions transactions;

	@Before
	public void initialise() {
		transactions = new Transactions();
	}

	@Test public void
	not_have_any_transactions_when_created() {
		List<Transaction> transactionList = transactions.all();

		assertThat(transactionList.isEmpty(), is(true));
	}

	@Test public void
	return_a_transaction_added() {
		Transaction transaction = new Transaction(100, "12/12/2013");
		transactions.add(transaction);

		List<Transaction> transactionList = transactions.all();

		assertThat(transactionList.size(), is(1));
		assertThat(transactionList.get(0), is(transaction));
	}

	@Test public void
	return_transaction_in_reverse_chronological_order() {
		Transaction transaction1 = new Transaction(100, "01/01/2001");
		Transaction transaction2 = new Transaction(200, "02/02/2002");
		transactions.add(transaction1);
		transactions.add(transaction2);

		List<Transaction> transactionList = transactions.all();

		assertThat(transactionList.size(), is(2));
		assertThat(transactionList.get(0), is(transaction2));
		assertThat(transactionList.get(1), is(transaction1));
	}

}