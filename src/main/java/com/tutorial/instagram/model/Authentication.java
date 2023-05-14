package com.tutorial.instagram.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_authentication")
public class Authentication {
	
	
	@Id
	@SequenceGenerator(name = "sequence_authentication",sequenceName = "sequence_authentication",allocationSize = 1,initialValue =5000 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_authentication")
	private Long tokenId;
	private String token;
	private LocalDate tokenCreationDate;


	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "fk_user_userId",nullable = false)
	private User user;


	public Authentication(User user) {
		token=UUID.randomUUID().toString();
		tokenCreationDate=LocalDate.now();
		this.user = user;
	
		
	}
	 
	 
	 

}
