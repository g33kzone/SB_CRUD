package com.g33kzone.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	public static Date currentDate() {

		return new Date();
	}

	public static Date formatDate(String dateString) throws ParseException {

		Date date = new SimpleDateFormat("dd-mmm-yyyy").parse(dateString);

		return date;
	}

}
