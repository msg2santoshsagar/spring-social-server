package com.sagar.springsocialserver.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagar.springsocialserver.domain.AppUser;
import com.sagar.springsocialserver.repository.AppUserRepository;

@Service
public class AppUserService {
	
	private static final Logger logger = LoggerFactory.getLogger(AppUserService.class);
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Transactional(readOnly=true)
	public Optional<AppUser> findOneByUserId(String userId){
		logger.debug(" FIND ONE BY USER ID : {} ",userId);
		return appUserRepository.findOneByUserId(userId);
	}

	public AppUser save(AppUser appUser) {
		return appUserRepository.save(appUser);
	}

	
	@Transactional
	public AppUser verifyAndsave(AppUser appUser) {
	
		Optional<AppUser> optionalUser =  findOneByUserId(appUser.getUserId());
		
		if(optionalUser.isPresent()){
			appUser.setId(optionalUser.get().getId());
		}
		
		return save(appUser);
	}	
}
