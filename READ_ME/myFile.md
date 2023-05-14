# Welcome to readme-md-generator &#x1F44B; 
![example workflow](https://img.shields.io/badge/Eclipse-Version%3A%202022--09%20(4.25.0)-orange)
![example workflow](https://img.shields.io/badge/SpringBoot-2.2.1-yellowgreen)
![example workflow](https://img.shields.io/badge/Java-8-yellowgreen)
![example workflow](https://img.shields.io/badge/Postman-v10.13-orange)
![example workflow](https://img.shields.io/badge/Documentation-Yes-green)
![example workflow](https://img.shields.io/badge/Manitained%3F-Yes-green)
 >CLI that generate beautiful **ReadME**.md files

  :house:  <b><span style="color: blue;">Homepage</span></b>
  


 # Prerequisties

 - **Eclipse >=4.55.0**
 - **Postman >=10.13**
 


# Install
```
Maven Install
SpringTool Install
```
 # Framework And Language

 - **Framework :  SpringBoot**
 - **Language :  Java**

 # Dependencies Required

 - **spring-boot-starter-validation**
 - **spring-boot-starter-web**
 - **spring-boot-devtools**
 - **lombok**
 - **spring-boot-starter-test**
 - **spring-boot-starter-data-jpa**
 - **mysql-connector**


# User Controller


```

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/signup")
	
	public SignUpOutputDao signUp(@Valid @RequestBody SignupInputDao input) {
		
		
		
		return userService.signUp(input);
		
		
	}
	
	@PostMapping("/signin")
	public SigninOutputDao signIn(@Valid @RequestBody SigninInputDao input) {
		
		return userService.signIn(input);
	}
	
	@PutMapping("/update/{token}")
	
	public ResponseEntity<String>updateUserDetails(@PathVariable("token") String token, @RequestBody SignupInputDao input){
		
		
		return userService.updateUserDetails(token,input);
	}
}
	
```


# Post Controller


```
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
	
```




	
	


  


	







	



# Database Used

<details>
<summary><b><span style="color: white;">Clickme</span></b> &#x1F4F2; </summary>

*Mysql*



</details>


# User Model

```
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_user")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	
	private Integer age;
	@Email
	private String email;
	@NonNull
	private String password;
	private String phoneNumber;
	
	
	
	
	
	
	
	
}
	
```


# Post Model

```
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
	
```

# Authentication Model

```
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
	
```


 # Database Design For User Model

 - **Primary Key :  User_id**
 - **Generationstrategy: IDENTITY**
  
  
 - **Columns Used:  User_id,first_name , last_name, age,email,password,Ph_number**

 # Database Design For Post Model

 - **Primary Key :  post_id**
 - **Generationstrategy:  SEQUENCE**
  
  - **Mapping with user:Many to one uni directional**
  
  
 - **Columns Used:  post_id,past_data , creation_date, update_date,fk_user_user_id**
 


# Database Design For Authentication Model

 - **Primary Key :  token_id**
 - **Generationstrategy:  Sequence**
  - **Mapping with user:one to one uni directional**
  

  
 - **Columns Used:  token_id,token, fk_user_userId, token_creationDate**




# Summary

 Spring Project for Instagram backend with models User,post,authentication
The project will have the following features
**provide user authentication**,
**update the user detials**,
**Post data**,
**get posts**
. Along with these proper validations are also provided.Used CRUD operation,Custom finders and Custom Query
to do necessary operations.






# :handshake:  Contributing
  Contributions,issues and features request are welcome! 
  

  #


  This *README* was generated with &#x2764;&#xFE0F; by <b><span style="color: blue;">readme-md-generator</span></b> 










   
  
  

