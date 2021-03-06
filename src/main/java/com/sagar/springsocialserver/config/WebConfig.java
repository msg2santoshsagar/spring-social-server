package com.sagar.springsocialserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("http://localhost:4200","http://127.0.0.1:4200",
				"http://spring-socialapp.vrqb9j7jng.us-east-1.elasticbeanstalk.com",
				"https://d3fkwrh7znes58.cloudfront.net",
				"http://d3fkwrh7znes58.cloudfront.net")
		.allowedMethods("GET","POST")
		.allowCredentials(true)
		.maxAge(3600);
	}
	
	
}
