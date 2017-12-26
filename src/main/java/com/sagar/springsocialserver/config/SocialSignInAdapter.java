package com.sagar.springsocialserver.config;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfile;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import com.sagar.springsocialserver.domain.AppUser;
import com.sagar.springsocialserver.domain.FacebookUser;
import com.sagar.springsocialserver.service.AppUserService;

@Component
public class SocialSignInAdapter implements SignInAdapter {

	@Autowired
	private AppUserService appUserService;

	@Override
	public String signIn(String localUserId, Connection<?> connection, NativeWebRequest nativeWebRequest) {
		System.out.println("=================== SIGN IN");

		Object apiObject =  connection.getApi();

		Facebook facebook = null;
		Twitter  twitter  = null;
		LinkedIn linkedin = null;
		
		boolean isFacebook =  false;
		boolean isTwitter  =  false;
		boolean isLinkedin =  false;
		
		
		if( apiObject instanceof Facebook ){
			facebook = (Facebook) apiObject;
			isFacebook = true;
		}else if ( apiObject instanceof Twitter ){
			twitter = (Twitter) apiObject;
			isTwitter = true;
		}else if( apiObject instanceof LinkedIn  ){
			linkedin = (LinkedIn) apiObject;
			isLinkedin =  true;
		}
		
		String userId = null;

		if( isFacebook ){
			String [] fields = { "id"};
			FacebookUser  facebookUser = facebook.fetchObject("me", FacebookUser.class, fields);

			userId = facebookUser.getId();
			System.out.println("===================================== FACE BOOK USER OBJECT IN SIGN IN :: "+facebookUser);
			System.out.println("===================== USR ID "+userId);

		}else if( isTwitter ){
			TwitterProfile twitterProfile = twitter.userOperations().getUserProfile();

			userId  = String.valueOf(twitterProfile.getId());

		}else if( isLinkedin ){
			
			LinkedInProfile linkedinProfile = linkedin.profileOperations().getUserProfile();
			
			userId  = linkedinProfile.getId();
			
		}else{
			System.err.println("SIGNIN : Api object is neither facebook nor twitter nor linkedin.");
		}

		if(userId == null){
			return null;
		}


		Optional<AppUser> optionalUser = appUserService.findOneByUserId(userId);

		System.out.println("OPTIONAL USER DATA FETCHED ---------------- ");

		AppUser appUser = optionalUser.get();

		List<GrantedAuthority> authorities = appUser.getRole().stream().map(role -> new SimpleGrantedAuthority(role.getName().toString())).collect(Collectors.toList());


		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken(
						userId, null, 
						authorities));



		return null;
	}

}
