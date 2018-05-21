package ua.com.entity;

import java.util.ArrayList;
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
@NamedQueries({
	@NamedQuery(name="findAll3",query="from Consumer"),
	
	@NamedQuery(name="findOneByName3",query="select c from Consumer c where c.userperson=:userperson")
})
@Entity
public class Consumer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String userperson;
	
	private String userlastname;
	
	private String email;
	;
	
	private String phonenumber;
	
	@ManyToMany
	@JoinTable(name="person_consumer",joinColumns = @JoinColumn(name="id_consumer"),
	inverseJoinColumns = @JoinColumn(name="id_person"))
	List<Person> person = new ArrayList<Person>();


	public Consumer() {
	}



	public Consumer(String userperson, String userlastname, String email, String phonenumber) {
		this.userperson = userperson;
		this.userlastname = userlastname;
		this.email = email;
		this.phonenumber = phonenumber;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserperson() {
		return userperson;
	}


	public void setUserperson(String userperson) {
		this.userperson = userperson;
	}


	public String getUserlastname() {
		return userlastname;
	}


	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
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


	public List<Person> getPerson() {
		return person;
	}


	public void setPerson(List<Person> person) {
		this.person = person;
	}


	@Override
	public String toString() {
		return "Consumer [id=" + id + ", userperson=" + userperson + ", userlastname=" + userlastname + ", email="
				+ email + ", phonenumber=" + phonenumber + ", person=" + person + "]";
	}


	
}