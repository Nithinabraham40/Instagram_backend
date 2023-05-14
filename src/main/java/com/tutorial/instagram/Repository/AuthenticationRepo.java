package com.tutorial.instagram.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tutorial.instagram.model.Authentication;

public interface AuthenticationRepo extends JpaRepository<Authentication, Long> {

public	Authentication findByToken(String token);


@Query(
		value="SELECT * FROM tbl_authentication where fk_user_user_id=:id",
		
		nativeQuery = true
		
		)
public Authentication findByUser(Long id);


	
	

}
