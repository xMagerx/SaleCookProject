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
	@NamedQuery(name="findAll8",query="from Recipes"),
	
	@NamedQuery(name="findOneByName8",query="select r from Recipes r where r.NameRecipes=:NameRecipes")
})

@Entity
public class Recipes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String NameRecipes;
	
	@ManyToOne
	private Person person;
	
	@OneToMany(mappedBy = "recipes",fetch = FetchType.LAZY)
	private List<Cakestorage> cakestorage = new ArrayList<Cakestorage>();

	public Recipes() {
	}


	public Recipes(String nameRecipes) {
		NameRecipes = nameRecipes;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameRecipes() {
		return NameRecipes;
	}

	public void setNameRecipes(String nameRecipes) {
		NameRecipes = nameRecipes;
	}


	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	


	public List<Cakestorage> getCakestorage() {
		return cakestorage;
	}

	public void setCakestorage(List<Cakestorage> cakestorage) {
		this.cakestorage = cakestorage;
	}

	@Override
	public String toString() {
		return "Recipes [id=" + id + ", NameRecipes=" + NameRecipes + ", person=" + person + ", cakestorage="
				+ cakestorage + "]";
	}








	
}