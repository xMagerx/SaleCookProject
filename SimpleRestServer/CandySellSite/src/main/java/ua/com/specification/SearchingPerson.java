package ua.com.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.entity.Person;
import ua.com.request.SearchingRequest;

public class SearchingPerson implements Specification<Person>{
	
	private SearchingRequest searchingRequest;
	
	public SearchingPerson(SearchingRequest searchingRequest) {
		this.searchingRequest = searchingRequest;
	}

	@Override
	public Predicate toPredicate(Root<Person> rootPerson, CriteriaQuery<?> crq, CriteriaBuilder crb) {
		CriteriaBuilder cb = crb;
		CriteriaQuery<?> cq =crq;
		Root<Person> root=  rootPerson;
		Predicate predicate = cb.like(root.get("email"),"%"+searchingRequest.getEmail()+"%");
		Predicate predicate2 = cb.like(root.get("nameperson"),"%"+searchingRequest.getNameperson()+"%");
		Predicate predicate3 = cb.like(root.get("lastname"),"%"+searchingRequest.getLastname()+"%");
		Predicate predicate4 = cb.like(root.get("phonenumber"),"%"+searchingRequest.getPhonenumber()+"%");
		Predicate predicate5 = cb.like(root.get("age"),"%"+searchingRequest.getAge()+"%");
		return cb.or(predicate, predicate2, predicate3, predicate4, predicate5);
		
	}
	

}
