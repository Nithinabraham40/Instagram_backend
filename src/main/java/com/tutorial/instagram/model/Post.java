package com.tutorial.instagram.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name = "tbl_post")
public class Post {
	
	
	@Id
	@SequenceGenerator(name = "post_sequence",sequenceName = "post_sequence",allocationSize = 1,initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "post_sequence")
	private Integer postId;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	private String postData;
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_user_user_id",nullable = false)
	private User user;
	
	
	
	
	

}
