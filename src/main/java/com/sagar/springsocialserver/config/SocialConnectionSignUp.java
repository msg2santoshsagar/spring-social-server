package com.sagar.springsocialserver.config;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.oauth2.UserInfo;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.api.LinkedInProfile;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Component;

import com.sagar.springsocialserver.domain.AppUser;
import com.sagar.springsocialserver.domain.FacebookUser;
import com.sagar.springsocialserver.domain.Role;
import com.sagar.springsocialserver.domain.RoleType;
import com.sagar.springsocialserver.service.AppUserService;
import com.sagar.springsocialserver.util.GeneralUtil;

@Component
public class SocialConnectionSignUp implements ConnectionSignUp {

	private static final Logger logger = LoggerFactory.getLogger(SocialConnectionSignUp.class);
	
	@Autowired
	private AppUserService appUserService;
	
	@Override
	public String execute(Connection<?> connection) {
		
		logger.debug("=====================================================================SOCIAL SIGN UP");
		
		Object apiObject =  connection.getApi();
		
		Facebook facebook = null;
		Twitter  twitter  = null;
		LinkedIn linkedin = null;
		Google	 google   = null;
		
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
			String [] fields = { "id", "email",  "first_name", "last_name" };
			FacebookUser  facebookUser = facebook.fetchObject("me", FacebookUser.class, fields);
			
			logger.debug("Facebook Profile Data :: {} ",GeneralUtil.convertToJsonString(facebookUser));
			
			String name = getFullName(facebookUser.getFirstName(), facebookUser.getLastName());
			
			AppUser appUser = new AppUser();
			appUser.setUserId(facebookUser.getId());
			appUser.setName(name);
			appUser.setEmail(facebookUser.getEmail());
			appUser.setPassword(String.valueOf(new Random().nextInt(Integer.MAX_VALUE)));
			Set<Role> authorities = new HashSet<>();
			authorities.add(new Role().setName(RoleType.ROLE_FB_USER));
			authorities.add(new Role().setName(RoleType.ROLE_SOCIAL_USER));
			appUser.setRole(authorities);
			appUser =  appUserService.verifyAndsave(appUser);
			userId =  appUser.getUserId();
		}else if( isTwitter ){
			
			TwitterProfile twitterProfile = twitter.userOperations().getUserProfile();
			
			logger.debug("Twitter Profile Data :: {} ",GeneralUtil.convertToJsonString(twitterProfile));
			 
			AppUser appUser = new AppUser();
			appUser.setUserId(String.valueOf(twitterProfile.getId()) );
			appUser.setName(twitterProfile.getName());
			appUser.setPassword(String.valueOf(new Random().nextInt(Integer.MAX_VALUE)));
			Set<Role> authorities = new HashSet<>();
			authorities.add(new Role().setName(RoleType.ROLE_TWITTER_USER));
			authorities.add(new Role().setName(RoleType.ROLE_SOCIAL_USER));
			appUser.setRole(authorities);
			appUser =  appUserService.verifyAndsave(appUser);
			userId =  appUser.getUserId();
			
		}else if( isLinkedin ){
			
			LinkedInProfile linkedinProfile = linkedin.profileOperations().getUserProfile();
			
			logger.debug("Linkedin Profile Data :: {} ",GeneralUtil.convertToJsonString(linkedinProfile));
			
			AppUser appUser = new AppUser();
			appUser.setUserId(String.valueOf(linkedinProfile.getId()) );
			appUser.setName(getFullName(linkedinProfile.getFirstName(),linkedinProfile.getLastName()));
			appUser.setEmail(linkedinProfile.getEmailAddress());
			appUser.setPassword(String.valueOf(new Random().nextInt(Integer.MAX_VALUE)));
			Set<Role> authorities = new HashSet<>();
			authorities.add(new Role().setName(RoleType.ROLE_LINKEDIN_USER));
			authorities.add(new Role().setName(RoleType.ROLE_SOCIAL_USER));
			appUser.setRole(authorities);
			appUser =  appUserService.verifyAndsave(appUser);
			userId =  appUser.getUserId();
			
		}else if( isGoogle ){
			UserInfo userInfo =google.oauth2Operations().getUserinfo();
			
			logger.debug("Google Profile Data :: {} ",GeneralUtil.convertToJsonString(userInfo));
			
			AppUser appUser = new AppUser();
			appUser.setUserId(userInfo.getId());
			appUser.setName(userInfo.getName());
			appUser.setEmail(userInfo.getEmail());
			appUser.setPassword(String.valueOf(new Random().nextInt(Integer.MAX_VALUE)));
			Set<Role> authorities = new HashSet<>();
			authorities.add(new Role().setName(RoleType.ROLE_GOOGLE_USER));
			authorities.add(new Role().setName(RoleType.ROLE_SOCIAL_USER));
			appUser.setRole(authorities);
			appUser =  appUserService.verifyAndsave(appUser);
			userId =  appUser.getUserId();
			
			
		}else{
			logger.error("SIGNUP Api object is not of mentioned types . {} ",(apiObject.getClass().getName()));
		}
		
		return userId;
	}
	
	
	private String getFullName(String firstName , String lastName){
		return ( (firstName == null ? " " : firstName ) + " "+ ( lastName == null ? "" : lastName ) ).trim();
		
	}

}
