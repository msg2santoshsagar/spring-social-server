package com.sagar.springsocialserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;

@Configuration
public class SocialConfiguration{

	@Autowired
	private ConnectionFactoryLocator connectionFactoryLocator;

	@Autowired
	private UsersConnectionRepository usersConnectionRepository;

	@Autowired
	private SocialConnectionSignUp socialConnectionSignUp;

	@Autowired
	private SocialSignInAdapter socialSignInAdapter;

	@Autowired
	private ApplicationProperties applicationProperties;



	@Bean
	public ProviderSignInController providerSignInController() {
		((InMemoryUsersConnectionRepository) usersConnectionRepository)
		.setConnectionSignUp(socialConnectionSignUp);

		ProviderSignInController providerSignInController = new ProviderSignInController(
				connectionFactoryLocator, 
				usersConnectionRepository, 
				socialSignInAdapter);

		providerSignInController.setSignInUrl(applicationProperties.getWebsiteUrl());

		return providerSignInController;

	}

}
