package com.tutorial.instagram.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SigninOutputDao {
	
	private String status;
	private String token;

}
