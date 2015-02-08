package com.codurance.bankkata;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class Transaction {

	private final int amount;
	private final String date;

	public Transaction(int amount, String date) {
		this.amount = amount;
		this.date = date;
	}

	public String date() {
		return this.date;
	}

	public int amount() {
		return amount;
	}

	@Override
	public boolean equals(Object o) {
		return reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"amount=" + amount +
				", date='" + date + '\'' +
				'}';
	}
}
