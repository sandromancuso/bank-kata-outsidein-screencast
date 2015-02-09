package com.codurance;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {
	public String dateAsString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return simpleDateFormat.format(new Date());
	}
}
