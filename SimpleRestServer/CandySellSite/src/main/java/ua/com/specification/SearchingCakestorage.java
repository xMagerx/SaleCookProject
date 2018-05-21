package ua.com.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.entity.Cakestorage;
import ua.com.entity.Person;
import ua.com.request.SearchingCakestorageRequest;
import ua.com.request.SearchingRequest;

public class SearchingCakestorage implements Specification<Cakestorage>{
	
	private SearchingCakestorageRequest searchingCakestorageRequest;
	
	public SearchingCakestorage(SearchingCakestorageRequest searchingCakestorageRequest) {
		this.searchingCakestorageRequest = searchingCakestorageRequest;
	}

	@Override
	public Predicate toPredicate(Root<Cakestorage> rootCakestorage, CriteriaQuery<?> crq, CriteriaBuilder crb) {
		CriteriaBuilder cb = crb;
		CriteriaQuery<?> cq =crq;
		Root<Cakestorage> root=  rootCakestorage;
		Predicate predicate = cb.like(root.get("ingridient"),"%"+searchingCakestorageRequest.getIngridient()+"%");
		Predicate predicate2 = cb.like(root.get("amount"),"%"+searchingCakestorageRequest.getAmount()+"%");

		return cb.or(predicate, predicate2);
		
	}

}
