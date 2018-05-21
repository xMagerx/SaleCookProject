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
	@NamedQuery(name="findAll6",query="from FormOfCake"),
	
	@NamedQuery(name="findOneByName6",query="select f from FormOfCake f where f.formOfCake=:formOfCake")
})
@Entity
public class FormOfCake {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String formOfCake;
	
	
	@OneToMany(mappedBy = "formOfCake",fetch = FetchType.LAZY)
	private List<NameCake> namecake = new ArrayList<NameCake>();

	

	public FormOfCake() {
	}




	public FormOfCake(String formOfCake) {
		this.formOfCake = formOfCake;
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFormOfCake() {
		return formOfCake;
	}



	public void setFormOfCake(String formOfCake) {
		this.formOfCake = formOfCake;
	}



	public List<NameCake> getNamecake() {
		return namecake;
	}



	public void setNamecake(List<NameCake> namecake) {
		this.namecake = namecake;
	}



	@Override
	public String toString() {
		return "FormOfCake [id=" + id + ", formOfCake=" + formOfCake + ", namecake=" + namecake + "]";
	}






	
	

}
