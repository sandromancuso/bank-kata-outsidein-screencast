package com.codurance;

import com.codurance.bankkata.Console;

public class RealApplication {

	public static void main(String[] args) {
		Clock clock = new Clock();
		Console console = new Console();
		Transactions transactions = new Transactions();
		StatementPrinter statementPrinter = new StatementPrinter(console);
		Account account = new Account(clock, transactions, statementPrinter);

		account.deposit(1000);
		account.withdraw(300);
		account.withdraw(50);
		account.deposit(500);

		account.printStatement();
	}

}
