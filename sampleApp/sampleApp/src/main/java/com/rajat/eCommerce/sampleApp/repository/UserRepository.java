package com.rajat.eCommerce.sampleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajat.eCommerce.sampleApp.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
