package com.sagar.springsocialserver.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	private DateUtil(){
		// Private constructor
	}

	/**
	 * To get current time in IST
	 * @return
	 */
	public static String getCurrentDateInIst(){
		LocalDateTime timePoint = LocalDateTime.now();
		return convertDateInIst(timePoint);
	}

	/**
	 * To convert given time in IST
	 * @param timePoint
	 * @return
	 */
	public static String convertDateInIst(LocalDateTime timePoint){

		ZoneId zoneId = ZoneId.of("Asia/Calcutta");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(timePoint, zoneId);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");

		return zonedDateTime.format(formatter);
	}

}
