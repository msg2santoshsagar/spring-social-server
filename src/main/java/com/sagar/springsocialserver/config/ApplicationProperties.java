package com.sagar.springsocialserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

	@Autowired
	private  Environment env;

	private ApplicationProperties(){
		// Private constructor
	}

	private  String  websiteUrl;

	public String getWebsiteUrl() {

		if( websiteUrl == null ){

			synchronized (env) {
				websiteUrl = env.getProperty("web-url-"+env.getProperty("profile","local"),"http://localhost:4200/");	
			}

		}

		return websiteUrl;
	}


}
