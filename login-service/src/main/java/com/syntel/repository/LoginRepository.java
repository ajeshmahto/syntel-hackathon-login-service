package com.syntel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.syntel.domain.User;

@RepositoryRestResource
public interface LoginRepository extends JpaRepository<User, String> {
	public User verifyLogin(String mobileNumber, String password);
		
	
}
