package com.tutorial.instagram.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tutorial.instagram.Repository.AuthenticationRepo;
import com.tutorial.instagram.Repository.PostRepo;
import com.tutorial.instagram.Repository.UserRepo;
import com.tutorial.instagram.model.Authentication;
import com.tutorial.instagram.model.Post;
import com.tutorial.instagram.model.User;

@Service
public class PostService {

	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private AuthenticationRepo authRepo;
	
	@Autowired
	private UserRepo userRepo;

	public ResponseEntity<String> post(String token, Post post) {
	
		Authentication authentication=authRepo.findByToken(token);
		
		if(authentication==null) {
			
			return new ResponseEntity<String>("Authentication failed",HttpStatus.BAD_REQUEST);
		}
		
		
		
		Long userId=authentication.getUser().getUserId();
		
		
		
		Optional<User> findUser=userRepo.findById(userId);
		User user=findUser.get();
		post.setUser(user);
		postRepo.save(post);
		
	
		
		return new ResponseEntity<String>("Post added sucessfully",HttpStatus.OK);
	}

	public ResponseEntity<List<Post>> getPost(String token) {
		
		List<Post>allPost=new ArrayList<>();
		

		Authentication authentication=authRepo.findByToken(token);
		
		if(authentication==null) {
			
			return new ResponseEntity<List<Post>>(allPost,HttpStatus.BAD_REQUEST);
		}

		Long userId=authentication.getUser().getUserId();
		
		allPost=postRepo.findAllPostById(userId);
		
		return new ResponseEntity<List<Post>>(allPost,HttpStatus.FOUND);
	}
}
