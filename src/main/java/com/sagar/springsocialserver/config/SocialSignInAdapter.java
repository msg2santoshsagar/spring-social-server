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
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.oauth2.UserInfo;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfile;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import com.sagar.springsocialserver.domain.AppUser;
import com.sagar.springsocialserver.domain.FacebookUser;
import com.sagar.springsocialserver.service.AppUserService;
import com.sagar.springsocialserver.util.CustomLogWriter;
import com.sagar.springsocialserver.util.GeneralUtil;

@Component
public class SocialSignInAdapter implements SignInAdapter {

	private static final CustomLogWriter clw = CustomLogWriter.getLogger(SocialSignInAdapter.class);


	@Autowired
	private AppUserService appUserService;

	@Override
	public String signIn(String localUserId, Connection<?> connection, NativeWebRequest nativeWebRequest) {
		
		clw.debug("=====================================================================SOCIAL SIGN UP");

		Object apiObject =  connection.getApi();

		Facebook facebook = null;
		Twitter  twitter  = null;
		LinkedIn linkedin = null;
		Google   google   = null;

		boolean isFacebook =  false;
		boolean isTwitter  =  false;
		boolean isLinkedin =  false;
		boolean isGoogle   =  false;


		if( apiObject instanceof Facebook ){
			facebook = (Facebook) apiObject;
			isFacebook = true;
		}else if ( apiObject instanceof Twitter ){
			twitter = (Twitter) apiObject;
			isTwitter = true;
		}else if( apiObject instanceof LinkedIn  ){
			linkedin = (LinkedIn) apiObject;
			isLinkedin =  true;
		}else if( apiObject instanceof Google ){
			google = (Google) apiObject;
			isGoogle = true;
		}

		String userId = null;

		if( isFacebook ){
			String [] fields = { "id"};
			FacebookUser  facebookUser = facebook.fetchObject("me", FacebookUser.class, fields);

			clw.debug("Facebook Profile Data :: ",GeneralUtil.convertToJsonString(facebookUser));

			userId = facebookUser.getId();

		}else if( isTwitter ){
			TwitterProfile twitterProfile = twitter.userOperations().getUserProfile();

			clw.debug("Twitter Profile Data :: ",GeneralUtil.convertToJsonString(twitterProfile));

			userId  = String.valueOf(twitterProfile.getId());

		}else if( isLinkedin ){

			LinkedInProfile linkedinProfile = linkedin.profileOperations().getUserProfile();

			clw.debug("Linkedin Profile Data :: ",GeneralUtil.convertToJsonString(linkedinProfile));

			userId  = linkedinProfile.getId();

		}else if( isGoogle ){

			UserInfo userInfo = google.oauth2Operations().getUserinfo();

			clw.debug("Google Profile Data :: ",GeneralUtil.convertToJsonString(userInfo));

			userId = userInfo.getId();

		}else{
			clw.error("SIGNIN Api object is not of mentioned types .",(apiObject.getClass().getName()));
		}

		if(userId == null){
			return null;
		}


		Optional<AppUser> optionalUser = appUserService.findOneByUserId(userId);

		clw.debug("OPTIONAL USER DATA FETCHED ---------------- ");

		if( optionalUser.isPresent()){
			AppUser appUser = optionalUser.get();

			List<GrantedAuthority> authorities = appUser.getRole().stream().map(role -> new SimpleGrantedAuthority(role.getName().toString())).collect(Collectors.toList());


			SecurityContextHolder.getContext().setAuthentication(
					new UsernamePasswordAuthenticationToken(
							userId, null, 
							authorities));


		}else{
			clw.debug("OPTIONAL USER DATA FETCHED, But No entry available corresponding to user in db ",userId);
		}



		return userId;
	}

}
