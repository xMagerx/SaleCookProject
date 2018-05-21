package ua.com.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class Person implements UserDetails{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nameperson;
	
	private String lastname;
	
	private int age;
	
	@NotNull
	private String email;
	
	private String password;
	
	private String phonenumber;
	
	private String photo;
	
	@ManyToMany
	@JoinTable(name="person_consumer",joinColumns = @JoinColumn(name="id_person"),
	inverseJoinColumns = @JoinColumn(name="id_consumer"))
	private List<Consumer> consumer = new ArrayList<Consumer>();
	

	@OneToMany(mappedBy = "person",fetch = FetchType.LAZY)
	private List<Delivery> delivery = new ArrayList<Delivery>();

	@OneToMany(mappedBy = "person",fetch = FetchType.LAZY)
	private List<Recipes> recipes = new ArrayList<Recipes>();
	
//	@Enumerated
	private Role role;

	public Person() {
	}

	
	public Person(int id, String nameperson, String lastname, int age, String email, String password, String phonenumber,
			String photo, Role role) {
		this.id = id;
		this.nameperson = nameperson;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
		this.photo = photo;
		this.role = role;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public void setPassword(String pass) {
		this.password = pass;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Consumer> getConsumer() {
		return consumer;
	}

	public void setConsumer(List<Consumer> consumer) {
		this.consumer = consumer;
	}

	public List<Delivery> getDelivery() {
		return delivery;
	}

	public void setDelivery(List<Delivery> delivery) {
		this.delivery = delivery;
	}

	public List<Recipes> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipes> recipes) {
		this.recipes = recipes;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", nameperson=" + nameperson + ", lastname=" + lastname + ", age=" + age
				+ ", email=" + email + ", pass=" + password + ", phonenumber=" + phonenumber + ", photo=" + photo
				+ ", consumer=" + consumer + ", delivery=" + delivery + ", recipes=" + recipes + ", role=" + role + "]";
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



	
	

	
}