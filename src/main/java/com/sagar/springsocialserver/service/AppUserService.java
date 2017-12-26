package com.sagar.springsocialserver.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagar.springsocialserver.domain.AppUser;
import com.sagar.springsocialserver.repository.AppUserRepository;

@Service
public class AppUserService {
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Transactional(readOnly=true)
	public Optional<AppUser> findOneByUserId(String userId){
		System.out.println(" FIND ONE BY USER ID ::: "+userId);
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
