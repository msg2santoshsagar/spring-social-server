package com.sagar.springsocialserver.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GeneralUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(GeneralUtil.class);
	

	private GeneralUtil(){
		// Private Constructor
	}
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	
	public static String convertToJsonString(Object object){
		String jsonString = null;
		try {
			jsonString = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			logger.error("Error occured while converting object to json.");
			printErrorLogs(e);
			
		}
		return jsonString;
	}
	
	private static void printErrorLogs(Exception e) {
		logger.error("============================================PRINTING ERROR LOGS :: START==============================================");
		if(e == null) {
			logger.error("e is null.");
		}else {
			logger.error(getExceptionStackTraceString(e));
		}
		logger.error("============================================PRINTING ERROR LOGS :: END==============================================");
	}

	private static String getExceptionStackTraceString(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter  pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}
	
	
}
