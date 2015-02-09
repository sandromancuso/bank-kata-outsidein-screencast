package acceptance;

import com.codurance.Account;
import com.codurance.Clock;
import com.codurance.Transactions;
import com.codurance.bankkata.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

	@Mock Console console;
	@Mock Clock clock;

	private Account account;

	@Before
	public void initialise() {
		Transactions transactions = new Transactions();
		account = new Account(clock, transactions);
	}

	@Test public void
	should_print_statement_containing_all_transactions() {
		account.deposit(1000);
		account.withdraw(100);
		account.deposit(500);

		account.printStatement();

		verify(console).printLine("DATE | AMOUNT | BALANCE");
		verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
		verify(console).printLine("02/04/2014 | -100.00 | 900.00");
		verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
	}
}
