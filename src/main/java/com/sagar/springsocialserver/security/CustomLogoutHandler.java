package com.sagar.springsocialserver.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * To handle logout success
 * 
 * @author santosh sagar
 *
 */
@Component
public class CustomLogoutHandler implements LogoutSuccessHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomLogoutHandler.class);
	
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		logger.info("Logout success for {} ", ( authentication == null ? "" : authentication.getName() ) );
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
