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

}