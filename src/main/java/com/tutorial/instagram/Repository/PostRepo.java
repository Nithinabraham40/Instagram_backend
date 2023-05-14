package com.tutorial.instagram.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tutorial.instagram.model.Post;

public interface PostRepo  extends JpaRepository<Post, Long>{

	
	@Query(
			value = "SELECT * FROM tbl_post where fk_user_user_id=:userId",
			nativeQuery = true
			)
	List<Post> findAllPostById(Long userId);

}
