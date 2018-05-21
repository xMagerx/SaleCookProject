package com.hipasserby.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hipasserby.entity.enums.Flag;
import com.hipasserby.entity.enums.Role;
import com.hipasserby.entity.enums.Sex;
import com.hipasserby.request.editUsersInformation.ContactInformationAboutUserRequest;
import com.hipasserby.request.editUsersInformation.EducationInformationAboutUserRequest;
import com.hipasserby.request.editUsersInformation.MainInformationAboutUserRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String email;


	@JsonIgnore
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String photo;

	private Role role;

	private Sex sex;

	private Flag flag;

	private String randomTokenOfActivation;

	private String credo;

	private String country;

	private String city;

	private String school;

	private String university;

	private int yearOfBirth;

	private int monthOfBirth;

	private int dayOfBirth;

	private String maritalStatus;

	private String language;

	private Date dateOfRegistration = new Date();

	private String phoneNumber;


	@JsonBackReference
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_DIALOGS",
			joinColumns = @JoinColumn(name = "ID_USER"),
			inverseJoinColumns = @JoinColumn(name = "ID_DIALOG"))
	private List<Dialog> dialogs = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "author")
	private List<Message> messages = new ArrayList<>();


	public User() {

	}

	//Registration constructor
	public User(String firstName, String lastName, String email, String password,Role role,Sex sex,Flag flag,String randomTokenOfActivation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.sex = sex;
		this.flag = flag;
		this.randomTokenOfActivation = randomTokenOfActivation;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCredo() {
		return credo;
	}

	public void setCredo(String credo) {
		this.credo = credo;
	}

	public List<Dialog> getDialogs() {
//		Collections.sort(dialogs);
		return dialogs;
	}

	public void setDialogs(List<Dialog> dialogs) {
		this.dialogs = dialogs;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

	public String getRandomTokenOfActivation() {
		return randomTokenOfActivation;
	}

	public void setRandomTokenOfActivation(String randomTokenOfActivation) {
		this.randomTokenOfActivation = randomTokenOfActivation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
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

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", photo='" + photo + '\'' +
				", role=" + role +
				", sex=" + sex +
				", flag=" + flag +
				", randomTokenOfActivation='" + randomTokenOfActivation + '\'' +
				", credo='" + credo + '\'' +
				", country='" + country + '\'' +
				", city='" + city + '\'' +
				", school='" + school + '\'' +
				", university='" + university + '\'' +
				", yearOfBirth=" + yearOfBirth +
				", monthOfBirth=" + monthOfBirth +
				", dayOfBirth=" + dayOfBirth +
				", maritalStatus='" + maritalStatus + '\'' +
				", language='" + language + '\'' +
				", dateOfRegistration=" + dateOfRegistration +
				", phoneNumber='" + phoneNumber + '\'' +
				", dialogs=" + dialogs +
				", messages=" + messages +
				'}';
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<GrantedAuthority>(Arrays.asList(new SimpleGrantedAuthority(role.name())));
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	//Edit main information method
	public void userEditMainInformation(MainInformationAboutUserRequest mainInformationAboutUserRequest) {
		this.firstName = mainInformationAboutUserRequest.getFirstName();
		this.lastName = mainInformationAboutUserRequest.getLastName();
		this.country = mainInformationAboutUserRequest.getCountry();
		this.city = mainInformationAboutUserRequest.getCity();
		this.yearOfBirth = mainInformationAboutUserRequest.getYearOfBirth();
		this.monthOfBirth = mainInformationAboutUserRequest.getMonthOfBirth();
		this.dayOfBirth = mainInformationAboutUserRequest.getDayOfBirth();
		this.maritalStatus = mainInformationAboutUserRequest.getMaritalStatus();
		this.language = mainInformationAboutUserRequest.getLanguage();
		this.credo = mainInformationAboutUserRequest.getCredo();
	}



	//Edit education information method
	public void userEditEducationInformation(EducationInformationAboutUserRequest educationInformationAboutUserRequest) {

		this.school = educationInformationAboutUserRequest.getSchool();
		this.university = educationInformationAboutUserRequest.getUniversity();

	}

	//Edit contact information method
    public void userEditContactInformation(ContactInformationAboutUserRequest contactInformationAboutUserRequest) {

		this.email = contactInformationAboutUserRequest.getEmail();
		this.phoneNumber = contactInformationAboutUserRequest.getPhoneNumber();

    }

}
