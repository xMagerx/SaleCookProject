package com.hipasserby.response;


import com.hipasserby.entity.User;

//lombok
public class UserResponse {

	private Integer id;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	public UserResponse (){}
	
	public UserResponse(User user){
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
	}

	public UserResponse(Integer id, String email, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "UserResponse [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}