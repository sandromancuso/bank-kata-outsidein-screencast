package com.codurance.bankkata;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {

	public String timeAsString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(new Date());
	}
}
