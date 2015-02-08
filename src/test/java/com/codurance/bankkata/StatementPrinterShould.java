package com.codurance.bankkata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.codurance.bankkata.StatementPrinter.STATEMENT_HEADER;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {

	@Mock Console console;
	private StatementPrinter statementPrinter;

	@Before
	public void initialise() {
	    statementPrinter = new StatementPrinter(console);
	}

	@Test public void
	print_the_statement_header_even_when_there_are_no_transactions() {
		List<Transaction> emptyListOfTransactions = new ArrayList<>();

		statementPrinter.print(emptyListOfTransactions);

		then(console).should().printLine(STATEMENT_HEADER);
	}

	@Test public void
	print_a_single_transaction_after_header() {
		Transaction transaction = new Transaction(500, "10/04/2014");
		List<Transaction> singleTransactionList = new ArrayList<>();
		singleTransactionList.add(transaction);

		statementPrinter.print(singleTransactionList);

		InOrder inOrder = inOrder(console);
		inOrder.verify(console).printLine(STATEMENT_HEADER);
		inOrder.verify(console).printLine("10/04/2014 | 500.00 | 500.00");
	}

	@Test public void
	print_multiple_transactions_with_a_running_balance() {
		Transaction transaction1 = new Transaction(500, "10/04/2014");
		Transaction transaction2 = new Transaction(-100, "12/04/2014");
		List<Transaction> singleTransactionList = new ArrayList<>();
		singleTransactionList.add(transaction1);
		singleTransactionList.add(transaction2);

		statementPrinter.print(singleTransactionList);

		InOrder inOrder = inOrder(console);
		inOrder.verify(console).printLine(STATEMENT_HEADER);
		inOrder.verify(console).printLine("12/04/2014 | -100.00 | 400.00");
		inOrder.verify(console).printLine("10/04/2014 | 500.00 | 500.00");
	}

}