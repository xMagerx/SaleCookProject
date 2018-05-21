package ua.com.response;

import ua.com.entity.Person;
//lombok
public class PersonResponse {
	
	private String email;
	
	private String nameperson;
	
	private String lastname;
	
	public PersonResponse (){}
	
	public PersonResponse(Person person){
		this.email = person.getEmail();
		this.nameperson = person.getNameperson();
		this.lastname = person.getLastname();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNameperson() {
		return nameperson;
	}

	public void setNameperson(String firstName) {
		this.nameperson = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastName) {
		this.lastname = lastName;
	}

	@Override
	public String toString() {
		return "PersonResponse [email=" + email + ", firstName=" + nameperson + ", lastName=" + lastname + "]";
	}

}