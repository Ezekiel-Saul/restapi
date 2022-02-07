package com.ezekiel.app.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezekiel.app.restapi.models.User;

public interface UserRepo extends JpaRepository<User, Long>{

	
}
