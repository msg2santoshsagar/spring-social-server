package com.sagar.springsocialserver.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		System.out.println("Logout success for  "+ ( authentication == null ? "" : authentication.getName() ) );
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
