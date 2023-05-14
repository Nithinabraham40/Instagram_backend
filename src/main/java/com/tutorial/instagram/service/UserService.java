package com.tutorial.instagram.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tutorial.instagram.Repository.AuthenticationRepo;
import com.tutorial.instagram.Repository.UserRepo;
import com.tutorial.instagram.dao.SignUpOutputDao;
import com.tutorial.instagram.dao.SigninInputDao;
import com.tutorial.instagram.dao.SigninOutputDao;
import com.tutorial.instagram.dao.SignupInputDao;
import com.tutorial.instagram.model.Authentication;
import com.tutorial.instagram.model.User;

import jakarta.validation.Valid;

@Service
public class UserService {

	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AuthenticationRepo authRepo;

	public SignUpOutputDao signUp(SignupInputDao input) {
		
		User user=userRepo.findByEmail(input.getEmail());
		
		if(user!=null) {
			
			return new SignUpOutputDao("User already exit");
		}
		
		String encryptedPassword=null;
		
		String password=input.getPassword();
		
		encryptedPassword=encryptPassword(password);
		
		
		user=User.builder().age(input.getAge()).email(input.getEmail()).firstName(input.getFirstName()).lastName(input.getLastName()).password(encryptedPassword).phoneNumber(input.getPhoneNumber()).build();
		
		userRepo.save(user);
		
		
		
		return new SignUpOutputDao("Sign up sucessfully!!!! Great");
	}
	
	
	
	
	
	
	   private String encryptPassword(String password) {
	       
        String salt = BCrypt.gensalt();

        
        String hashedPassword = BCrypt.hashpw(password, salt);

        return hashedPassword;
    }
	
	
	
	
	   
	   
	   
	   private boolean verifyPassword(String password, String hashedPassword) {
	    return BCrypt.checkpw(password, hashedPassword);
	}
	
	
	
	
	

	     public SigninOutputDao signIn(@Valid SigninInputDao input) {
	  	
		  User user=userRepo.findByEmail(input.getEmail());
		
		  if(user==null) {
			
			return new SigninOutputDao("Give valid email","click help");
		 }
		
		String password=input.getPassword();
		String encryptedpassword=user.getPassword();
		
		boolean verify=verifyPassword(password,encryptedpassword);
		
		if(verify==false) {
			
			return new SigninOutputDao("Signin failed","click help");
			
		}
		Long id=user.getUserId();
		
		Authentication auth=authRepo.findByUser(id);
		
		if(auth!=null) {
			

			return new SigninOutputDao("Welcome!!!",auth.getToken());
		}
		
		
		
	  auth=new Authentication(user);
		
		authRepo.save(auth);
		
		
		
		
		return new SigninOutputDao("Welcome!!!",auth.getToken());
	}

	     
	     
	     
	     
	public ResponseEntity<String> updateUserDetails(String token,SignupInputDao input) {
		
		
		Authentication authentication=authRepo.findByToken(token);
		
		if(authentication==null) {
			
			return new ResponseEntity<String>("authentication failed",HttpStatus.BAD_REQUEST);
		}
		
		String password=input.getPassword();
		
		String encryptedPassword=encryptPassword(password);
		
		
		Optional<User> findUser=userRepo.findById(authentication.getUser().getUserId());
		
		User user=findUser.get();
		
		authRepo.delete(authentication);
		userRepo.delete(user);
		
		
		
		
		user=User.builder().age(input.getAge()).email(input.getEmail()).firstName(input.getFirstName()).lastName(input.getLastName()).password(encryptedPassword).phoneNumber(input.getPhoneNumber()).build();
		
		userRepo.save(user);
		

		
		
		return new ResponseEntity<String>("Sucessfully update",HttpStatus.ACCEPTED);
	}

}
