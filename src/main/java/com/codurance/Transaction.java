package com.codurance;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;

public class Transaction {

	private final String systemTime;
	private final int amount;

	public Transaction(String date, int amount) {
		this.systemTime = date;
		this.amount = amount;
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
				"date='" + systemTime +
				", amount=" + amount + '\'' +
				'}';
	}
}
