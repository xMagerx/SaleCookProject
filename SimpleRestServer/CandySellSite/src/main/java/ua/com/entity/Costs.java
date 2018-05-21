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
	@NamedQuery(name="findAll4",query="from Costs"),
	
	@NamedQuery(name="findOneByName4",query="select c from Costs c where c.timeproduction=:timeproduction")
})
@Entity
public class Costs {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String timeproduction;
	
	private int complexityPay;
	
	@ManyToOne
	private Cakestorage cakestorage;
	

	
	public Costs() {
	}




	public Costs(String timeproduction, int complexityPay) {
		this.timeproduction = timeproduction;
		this.complexityPay = complexityPay;
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTimeproduction() {
		return timeproduction;
	}



	public void setTimeproduction(String timeproduction) {
		this.timeproduction = timeproduction;
	}



	public int getComplexityPay() {
		return complexityPay;
	}



	public void setComplexityPay(int complexityPay) {
		this.complexityPay = complexityPay;
	}



	public Cakestorage getCakestorage() {
		return cakestorage;
	}



	public void setCakestorage(Cakestorage cakestorage) {
		this.cakestorage = cakestorage;
	}



	@Override
	public String toString() {
		return "Costs [id=" + id + ", timeproduction=" + timeproduction + ", complexityPay=" + complexityPay
				+ ", cakestorage=" + cakestorage + "]";
	}
	
	
}