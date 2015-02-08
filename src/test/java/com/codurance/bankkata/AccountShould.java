package com.codurance.bankkata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

	@Mock Transactions transactions;
	@Mock Clock clock;
	@Mock StatementPrinter statementPrinter;

	private Account account;

	@Before
	public void initialise() {
	    account = new Account(clock, transactions, statementPrinter);
	}

	@Test public void
	store_a_deposit_transaction() {
		given(clock.timeAsString()).willReturn("01/04/2014");
		Transaction deposit = new Transaction(1000, "01/04/2014");

		account.deposit(1000);

		verify(transactions).add(eq(deposit));
	}
	
	@Test public void
	store_a_withdrawal_transaction() {
		given(clock.timeAsString()).willReturn("02/04/2014");
		Transaction withdrawal = new Transaction(-100, "02/04/2014");

		account.withdraw(100);

		verify(transactions).add(eq(withdrawal));
	}

	@Test public void
	print_a_statement_with_all_transactions() {
		List<Transaction> allTransactions = new ArrayList<>();
		given(transactions.all()).willReturn(allTransactions);

		account.printStatement();

		verify(statementPrinter).print(allTransactions);
	}
}
