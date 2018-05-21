package ua.com.request;

public class LoginRequest {
	
	private String email;
	
	private String pass;
	
	public LoginRequest(){}

	public LoginRequest(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "LoginRequest [email=" + email + ", pass=" + pass + "]";
	}

}
