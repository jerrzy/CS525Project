package com.dictionary;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Configuration {

	public static final String DataPattern = "MMMM d, yyyy HH:mm:ss";

	public static Date String2Date(String dateS) {

		DateFormat formatter = new SimpleDateFormat(DataPattern);
		Date date = null;
		try {
			date = formatter.parse(dateS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String nowS() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DataPattern);
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public static Date now() {
		return String2Date(nowS());
	}
}
