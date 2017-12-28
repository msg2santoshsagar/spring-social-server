package com.sagar.springsocialserver.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	
	private DateUtil(){
		// Private constructor
	}
	
	public static String getCurrentDateInIst(){
		
		LocalDateTime timePoint = LocalDateTime.now();
		ZoneId zoneId = ZoneId.of("Asia/Calcutta");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(timePoint, zoneId);
				
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
		
		
		return zonedDateTime.format(formatter);
	}

}
