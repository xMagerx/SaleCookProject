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
	@NamedQuery(name="findAll2",query="from CakeValue"),
	
	@NamedQuery(name="findOneByName2",query="select v from CakeValue v where v.V=:V")
})
@Entity
public class CakeValue {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String V;

	
	@OneToMany(mappedBy = "cakeValue",fetch = FetchType.LAZY)
	private List<NameCake> namecake = new ArrayList<NameCake>();

	
	public CakeValue() {
	}



	public CakeValue(String v) {
		V = v;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getV() {
		return V;
	}


	public void setV(String v) {
		V = v;
	}


	public List<NameCake> getNamecake() {
		return namecake;
	}


	public void setNamecake(List<NameCake> namecake) {
		this.namecake = namecake;
	}


	@Override
	public String toString() {
		return "CakeValue [id=" + id + ", V=" + V + ", namecake=" + namecake + "]";
	}
	
	
}