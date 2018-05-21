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
@NamedQueries({
	@NamedQuery(name="findAll7",query="from NameCake"),
	
	@NamedQuery(name="findOneByName7",query="select n from NameCake n where n.name=:name")
})
@Entity
public class NameCake {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToOne
	private FormOfCake formOfCake;

	@ManyToOne
	private CakeValue cakeValue;

	public NameCake() {
	}


	public NameCake(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FormOfCake getFormOfCake() {
		return formOfCake;
	}

	public void setFormOfCake(FormOfCake formOfCake) {
		this.formOfCake = formOfCake;
	}



	public CakeValue getCakeValue() {
		return cakeValue;
	}

	public void setCakeValue(CakeValue cakeValue) {
		this.cakeValue = cakeValue;
	}

	@Override
	public String toString() {
		return "NameCake [id=" + id + ", name=" + name + ", formOfCake=" + formOfCake + ", cakeValue=" + cakeValue
				+ "]";
	}




	
	
	

}
