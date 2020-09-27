package com.uob.uobbank.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtills {


	public static LocalDateTime stringToDate(String str, String dateFormate) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormate);
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

		return dateTime;
	}

	public static int getYearFromDAte(Date parsedDate) {
		Calendar myCal = new GregorianCalendar();
		myCal.setTime(parsedDate);

		return myCal.get(Calendar.YEAR);
	}

	// getting month start date and end date based on year and month
	public static String getMonthFirstDay(int year, int month) {

		YearMonth yearMonth = YearMonth.of(year, month);
		LocalDate fromDateFirstDayOfMonth = yearMonth.atDay(1);
		String fromDateData = fromDateFirstDayOfMonth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return fromDateData;
	}

	// getting month end date and end date based on year and month
	public static String getMonthLastDay(int year, int month) {

		YearMonth yearMonth = YearMonth.of(year, month);
		LocalDate fromDateLastDayOfMonth = yearMonth.atEndOfMonth();
		String toDateData = fromDateLastDayOfMonth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return toDateData;
	}

	public static int getMonthNumber(String monthName) {
		return Month.valueOf(monthName.toUpperCase()).getValue();
	}

	public static int getMonthDaysCount(int year, int month) {

		YearMonth yearMonthObject = YearMonth.of(year, month);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		return daysInMonth;
	}

	public static String getMonthLastDaysss(int year, int month) {

		YearMonth yearMonth = YearMonth.of(year, month);
		LocalDate last = yearMonth.atEndOfMonth();
		String toDateData = last.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return toDateData;
	}

}
