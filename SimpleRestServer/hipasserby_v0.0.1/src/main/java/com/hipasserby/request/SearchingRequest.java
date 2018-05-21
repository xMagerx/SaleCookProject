package com.hipasserby.request;

public class SearchingRequest {

	private String firstName;

	private String lastName;

	private String country;

	private String email;

	private int yearOfBirth;

	private int monthOfBirth;

	private int dayOfBirth;

	public SearchingRequest() {}

	public SearchingRequest(String email) {
		this.email = email;
	}

	public SearchingRequest(String firstName, String lastName, String country, String email, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.email = email;
		this.yearOfBirth = yearOfBirth;
		this.monthOfBirth = monthOfBirth;
		this.dayOfBirth = dayOfBirth;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public int getMonthOfBirth() {
		return monthOfBirth;
	}

	public void setMonthOfBirth(int monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}

	public int getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(int dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}


	@Override
	public String toString() {
		return "SearchingRequest{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", country='" + country + '\'' +
				", yearOfBirth=" + yearOfBirth +
				", monthOfBirth=" + monthOfBirth +
				", dayOfBirth=" + dayOfBirth +
				", email='" + email + '\'' +
				'}';
	}
}
