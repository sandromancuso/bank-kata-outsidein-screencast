package com.codurance;

import com.codurance.bankkata.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static com.codurance.StatementPrinter.STATEMENT_HEADER;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {

	private static final List NO_TRANSACIONS = Collections.EMPTY_LIST;

	@Mock Console console;

	private StatementPrinter statementPrinter;

	@Before
	public void initialise() {
	    statementPrinter = new StatementPrinter(console);
	}

	@Test public void
	print_header_even_when_there_are_no_transactions() {
		statementPrinter.print(NO_TRANSACIONS);

		verify(console).printLine(STATEMENT_HEADER);
	}

	@Test public void
	print_transactions_in_reverse_chronological_order() {
		Transaction deposit_1 = new Transaction("01/04/2014", 1000);
		Transaction withdrawal = new Transaction("02/04/2014", -100);
		Transaction deposit_2 = new Transaction("10/04/2014", 500);
		List<Transaction> transactionList = asList(deposit_1, withdrawal, deposit_2);

		statementPrinter.print(transactionList);

		verify(console).printLine("DATE | AMOUNT | BALANCE");
		verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
		verify(console).printLine("02/04/2014 | -100.00 | 900.00");
		verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
	}

}