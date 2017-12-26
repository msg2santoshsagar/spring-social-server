package com.sagar.springsocialserver.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.sagar.springsocialserver.domain.AppUser;

import java.util.Optional;

/**
 * Spring Data JPA repository for the User entity.
 */
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	Optional<AppUser> findOneByUserId(String userId);

}