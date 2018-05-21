package ua.com.response;

import ua.com.entity.Person;
//lombok
public class PersonResponse {
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	public PersonResponse (){}
	
	public PersonResponse(Person person){
		this.email = person.getEmail();
		this.firstName = person.getNameperson();
		this.lastName = person.getLastname();
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
		return "PersonResponse [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}