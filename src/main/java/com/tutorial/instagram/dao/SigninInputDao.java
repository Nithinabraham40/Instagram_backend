package com.tutorial.instagram.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SigninInputDao {
	
	private String email;
	private String password;

}
