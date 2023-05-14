package com.tutorial.instagram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.instagram.model.Post;
import com.tutorial.instagram.service.PostService;

@RestController
@RequestMapping("/post")
public class Postcontroller {

	
	@Autowired
	private PostService postService;
	
	
	@PostMapping("/{token}")
	
	public ResponseEntity<String>post(@PathVariable("token") String token,@RequestBody Post post){
		
		return postService.post(token,post);
		
	}
	
	@GetMapping("/getpost/{token}")
	
	public ResponseEntity<List<Post>>getPost(@PathVariable ("token")String token){
		
		return postService.getPost(token);
		
		
		
	}
	
	
}
