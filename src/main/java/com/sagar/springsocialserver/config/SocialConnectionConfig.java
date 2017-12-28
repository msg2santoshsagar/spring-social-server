package com.sagar.springsocialserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.google.connect.GoogleConnectionFactory;

@Configuration
@EnableSocial
@EnableAutoConfiguration
public class SocialConnectionConfig extends SocialConfigurerAdapter{
	
	@Autowired
	private Environment env;
	
	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer,
			Environment environment) {
		super.addConnectionFactories(connectionFactoryConfigurer, environment);
		
		String googleAppId     = env.getProperty("spring.social.google.appId");
		String googleAppSecret = env.getProperty("spring.social.google.appSecret");
		
		System.out.println("GOOGLE APP ID "+googleAppId+" GOOGLE API SECRET KEY "+googleAppSecret);
		
		connectionFactoryConfigurer.addConnectionFactory(new GoogleConnectionFactory(googleAppId,googleAppSecret));
	}


}
