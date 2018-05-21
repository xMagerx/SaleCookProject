package ua.com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@NamedQueries({
	@NamedQuery(name="findAll5",query="from Delivery"),
	
	@NamedQuery(name="findOneByName5",query="select d from Delivery d where d.delivery=:delivery")
})
@Entity
public class Delivery {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String delivery;
	
    	
	@ManyToOne
	private Person person;
	
	public Delivery() {
	}



	public Delivery(String delivery) {
		this.delivery = delivery;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", delivery=" + delivery + ", person=" + person + "]";
	}
	
}