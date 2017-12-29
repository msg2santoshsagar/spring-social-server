package com.sagar.springsocialserver.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * A rest controller for providing application information detail.
 * 
 * @author   santosh sagar
 * @version  0.0.1
 *
 */
@RestController
@RequestMapping(value="/api")
public class ApplicationInformationController {
	
	@Autowired
	Environment environment;
	
	private final static Date startDate = new Date();
	
	private Map<String, String> applicationInformationMap;

	/**
	 * It will help to initialize the value of applicationInformationMap
	 * It will automatically get invoked, when the class initialized.
	 */
	@PostConstruct
	private void init(){
		applicationInformationMap = new HashMap<>();
		applicationInformationMap.put("name", "Spring social service");
		applicationInformationMap.put("version", "0.0.1");
		applicationInformationMap.put("UP_TIME", startDate.toString());
	}

	/**
	 * Get  : /ping : to get application information detail
	 * Post : /ping : to get application information detail
	 * 
	 * @return a map which will have application detail
	 */
	@RequestMapping(value="/ping",method={RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, String> ping(){
		return applicationInformationMap;
	}
	

}
