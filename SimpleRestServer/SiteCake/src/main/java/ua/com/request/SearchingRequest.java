package ua.com.request;

public class SearchingRequest {

	private String email;

	public SearchingRequest() {}

	public SearchingRequest(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SearchingRequest [email=" + email + "]";
	}
	
}
