package com.sagar.springsocialserver.controller;


import java.time.LocalDateTime;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.springsocialserver.domain.constants.AppConstant;
import com.sagar.springsocialserver.domain.model.ApplicationInfo;
import com.sagar.springsocialserver.util.DateUtil;

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
	
	private final static LocalDateTime startTimePoint = LocalDateTime.now();

	/**
	 * It will help to initialize the value of applicationInformationMap
	 */
	private ApplicationInfo getApplicationInfo(){
		return new ApplicationInfo().setName("Spring social service")
				.setVersion(AppConstant.APP_VERSION)
				.setUpTime(DateUtil.convertDateInIst(startTimePoint));
	}

	/**
	 * Get  : /ping : to get application information detail
	 * Post : /ping : to get application information detail
	 * 
	 * @return a map which will have application detail
	 */
	@RequestMapping(value="/ping",method={RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ApplicationInfo ping(){
		return getApplicationInfo();
	}
	

}
