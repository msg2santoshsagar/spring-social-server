package com.sagar.springsocialserver.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GeneralUtil {
	
	private static final CustomLogWriter clw = CustomLogWriter.getLogger(GeneralUtil.class);
	

	private GeneralUtil(){
		// Private Constructors
	}
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	
	public static String convertToJsonString(Object object){
		String jsonString = null;
		try {
			jsonString = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			clw.error("Error occured while converting object to json :: "+e);
		}
		return jsonString;
	}
	
	
}
