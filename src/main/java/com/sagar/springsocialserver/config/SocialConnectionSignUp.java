package com.sagar.springsocialserver.config;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;
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

	private static final String TAG = SocialConnectionSignUp.class.getSimpleName();
	
	
	@Autowired
	private AppUserService appUserService;
	
	@Override
	public String execute(Connection<?> connection) {
		
		System.out.println("=================== SIGN UP");
		
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
			String [] fields = { "id", "email",  "first_name", "last_name" };
			FacebookUser  facebookUser = facebook.fetchObject("me", FacebookUser.class, fields);
			System.out.println(" SIGNUP USER PROFILE FACEBOOK :: "+facebookUser);
			
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
			
			long     id  = twitterProfile.getId();
			String  name = twitterProfile.getName();
			 
			AppUser appUser = new AppUser();
			appUser.setUserId(String.valueOf(id) );
			appUser.setName(name);
			appUser.setPassword(String.valueOf(new Random().nextInt(Integer.MAX_VALUE)));
			Set<Role> authorities = new HashSet<>();
			authorities.add(new Role().setName(RoleType.ROLE_TWITTER_USER));
			authorities.add(new Role().setName(RoleType.ROLE_SOCIAL_USER));
			appUser.setRole(authorities);
			appUser =  appUserService.verifyAndsave(appUser);
			userId =  appUser.getUserId();
			
		}else if( isLinkedin ){
			
			LinkedInProfile linkedinProfile = linkedin.profileOperations().getUserProfile();
			
			GeneralUtil.convertValueToJsonAndPrint(TAG, "Linkedin Profile Data", linkedinProfile);
			
			
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
			
		}else{
			System.err.println("SIGNUP Api object is neither facebook nor twitter nor linkedin.");
		}
		
		return userId;
	}
	
	
	private String getFullName(String firstName , String lastName){
		return ( (firstName == null ? " " : firstName ) + " "+ ( lastName == null ? "" : lastName ) ).trim();
		
	}

}
