package com.sagar.springsocialserver.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.sagar.springsocialserver.security.CustomAuthenticationEntryPoint;
import com.sagar.springsocialserver.security.CustomAuthenticationFailureHandler;
import com.sagar.springsocialserver.security.CustomAuthenticationSuccessHandler;
import com.sagar.springsocialserver.security.CustomLogoutHandler;
import com.sagar.springsocialserver.security.CustomUserDetailService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationManagerBuilder authenticationManagerBuilder;

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	
	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired CustomLogoutHandler customLogoutHandler;
	
	@Autowired
	private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
	
	@PostConstruct
	public void init() {
		try {
			authenticationManagerBuilder.userDetailsService(customUserDetailService);
		} catch (Exception e) {
			throw new BeanInitializationException("Security configuration failed", e);
		}
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.formLogin()
		.loginPage("/api/login")
		.successHandler(customAuthenticationSuccessHandler)
		.failureHandler(customAuthenticationFailureHandler)
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/api/logout")
		.logoutSuccessHandler(customLogoutHandler)
		.permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/signin/**","/signup/**").permitAll()
		.antMatchers("/api/ping").permitAll()
		.antMatchers("/api/auth").authenticated();

		http.csrf().disable();
		http.cors();
		http.exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint);
	}

}