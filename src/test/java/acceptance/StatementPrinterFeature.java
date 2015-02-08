package acceptance;

import com.codurance.bankkata.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterFeature {

	@Mock Console console;
	@Mock Clock clock;

	private Account account;

	@Before
	public void initialise() {
		Transactions transactions = new Transactions();
		StatementPrinter statementPrinter = new StatementPrinter(console);
		account = new Account(clock, transactions, statementPrinter);
	}

	@Test public void
	print_transactions_in_reverse_chronological_order() {
		given(clock.timeAsString()).willReturn("01/04/2014", "02/04/2014", "10/04/2014");

		account.deposit(1000);
		account.withdraw(100);
		account.deposit(500);

		account.printStatement();

		InOrder inOrder = Mockito.inOrder(console);
		inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
		inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
		inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
		inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
	}
}
