package com.sagar.springsocialserver.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GeneralUtil {

	private GeneralUtil(){
		// Private Constructors
	}
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	
	public static String convertToJsonString(Object object){
		String jsonString = null;
		try {
			jsonString = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			System.err.println("Error occured while converting object to json :: "+e);
		}
		return jsonString;
	}
	
	public static void convertValueToJsonAndPrint(String tag, String message, Object data){
		System.out.println();
		System.out.println();
		System.out.print(tag);
		System.out.print(" :: ");
		System.out.print(message);
		System.out.print(" :: ");
		System.out.println(convertToJsonString(data));
		System.out.println();
		System.out.println();
	}
	
}
