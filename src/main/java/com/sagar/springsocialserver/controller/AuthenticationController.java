package com.sagar.springsocialserver.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.springsocialserver.domain.AppUser;
import com.sagar.springsocialserver.domain.MaskedUser;
import com.sagar.springsocialserver.service.AppUserService;

@RestController
@RequestMapping(value="/api")
public class AuthenticationController {

	@Autowired
	private AppUserService appUserService;

	@RequestMapping(value="/auth",method={RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	public MaskedUser getAuth(){

		System.out.println("==============================================================================================================================");

		MaskedUser user = null;

		Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();

		System.out.println("Authentication OBJ : "+authentication);

		Object userDetailsObj = authentication.getPrincipal();

		System.out.println("USER DETAILS OBJ : "+userDetailsObj+" \n class : "+userDetailsObj.getClass().getName());

		String userName = null;

		if( userDetailsObj  instanceof UserDetails ){
			UserDetails userDetail = (UserDetails) userDetailsObj;
			userName = userDetail.getUsername();
		}else if ( userDetailsObj instanceof String){
			userName = (String) userDetailsObj;
		}

		if(userName != null){
			
			Optional<AppUser> optionalAppUser = appUserService.findOneByUserId(userName);
			
			if(optionalAppUser.isPresent()){
				user = new MaskedUser();
				AppUser appUser = optionalAppUser.get();
				user.setUserName(appUser.getUserId());
				user.setRole(appUser.getRole());

				user.setEmail(appUser.getEmail());
				user.setName(appUser.getName());
			}	
		}




		return user;
	}


}