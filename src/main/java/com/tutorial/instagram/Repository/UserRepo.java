package com.tutorial.instagram.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.instagram.model.User;

public interface UserRepo extends  JpaRepository<User, Long>{

	User findByEmail(String email);

}
