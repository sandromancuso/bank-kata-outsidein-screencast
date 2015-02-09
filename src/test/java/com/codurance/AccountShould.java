package com.codurance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

	private static final String SYSTEM_DATE = "01/04/2004";

	@Mock Transactions transactions;
	@Mock Clock clock;

	private Account account;

	@Before
	public void initialise() {
	    account = new Account(clock, transactions);
	}

	@Test public void
	store_a_deposit_transaction() {
		given(clock.dateAsString()).willReturn(SYSTEM_DATE);
		Transaction deposit = new Transaction(SYSTEM_DATE, 100);

		account.deposit(100);

		verify(transactions).add(eq(deposit));
	}
}
