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


@Entity
public class Cakestorage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String ingridient;
	
	private String amount;
	
	@ManyToOne
	private Recipes recipes;

	@OneToMany(mappedBy = "cakestorage",fetch = FetchType.LAZY)
	private List<Costs> costs = new ArrayList<Costs>();
	
	public Cakestorage() {
	}



	public Cakestorage(String ingridient, String amount) {

		this.ingridient = ingridient;
		this.amount = amount;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIngridient() {
		return ingridient;
	}


	public void setIngridient(String ingridient) {
		this.ingridient = ingridient;
	}





	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public List<Costs> getCosts() {
		return costs;
	}


	public void setCosts(List<Costs> costs) {
		this.costs = costs;
	}


	public Recipes getRecipes() {
		return recipes;
	}


	public void setRecipes(Recipes recipes) {
		this.recipes = recipes;
	}


	@Override
	public String toString() {
		return "Cakestorage [id=" + id + ", ingridient=" + ingridient + ", amount=" + amount + ", recipes=" + recipes
				+ ", costs=" + costs + "]";
	}





	}