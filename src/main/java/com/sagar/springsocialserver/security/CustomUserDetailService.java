package com.sagar.springsocialserver.security;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sagar.springsocialserver.domain.AppUser;
import com.sagar.springsocialserver.service.AppUserService;

/**
 * Custom class to manage user authentication
 * 
 * @author santosh sagar
 *
 */
@Component
public class CustomUserDetailService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);
	

	@Autowired
	private AppUserService appUserService;

	Short counter = 1;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String userId) {

		logger.debug("Request to loadUserByUsername   {} , {}",counter, userId);

		if (counter == Short.MAX_VALUE) {
			counter = 0;
		}

		String lowercaseUserId = userId.toLowerCase();

		Optional<AppUser> userOptional = appUserService.findOneByUserId(lowercaseUserId);
		if (userOptional.isPresent()) {
			// If User is available
			AppUser appUser = userOptional.get();
			
			logger.debug("APP USER GET ROLE ::: =========  {} ",appUser.getRole());

			List<GrantedAuthority> grantedAuthorities = appUser.getRole().stream()
					.map(role -> new SimpleGrantedAuthority(role.getName().toString())).collect(Collectors.toList());

			User  user =  new User(lowercaseUserId, appUser.getPassword(), grantedAuthorities);
			logger.debug("Login Successfull  :: {} ",user);
			return user;

		} else {
			logger.info("Login failed for user :: {} " ,lowercaseUserId);
			throw new UsernameNotFoundException("User " + lowercaseUserId + " was not found in database.");
		}

	}

}
