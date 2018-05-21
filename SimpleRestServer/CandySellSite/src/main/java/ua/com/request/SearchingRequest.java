package ua.com.request;

public class SearchingRequest {
	
	private String nameperson;
	
	private String lastname;
	
	private String email;
	
	private String phonenumber;
	
	private int age;

	public SearchingRequest() {}



	public SearchingRequest(String nameperson, String lastname, String email, String phonenumber, int age) {
		this.nameperson = nameperson;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.age = age;
	}



	public String getNameperson() {
		return nameperson;
	}



	public void setNameperson(String nameperson) {
		this.nameperson = nameperson;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "SearchingRequest [nameperson=" + nameperson + ", lastname=" + lastname + ", email=" + email
				+ ", phonenumber=" + phonenumber + ", age=" + age + "]";
	}




	
}
