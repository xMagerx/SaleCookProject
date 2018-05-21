package ua.com.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.entity.Costs;
import ua.com.entity.Person;
import ua.com.request.SearchingCostRequest;
import ua.com.request.SearchingRequest;

public class SearchingCost implements Specification<Costs>{
	
	private SearchingCostRequest searchingCostRequest;
	
	public SearchingCost(SearchingCostRequest searchingCostRequest) {
		this.searchingCostRequest = searchingCostRequest;
	}

	@Override
	public Predicate toPredicate(Root<Costs> rootCosts, CriteriaQuery<?> crq, CriteriaBuilder crb) {
		CriteriaBuilder cb = crb;
		CriteriaQuery<?> cq =crq;
		Root<Costs> root=  rootCosts;
		Predicate predicate = cb.like(root.get("timeproduction"),"%"+searchingCostRequest.getTimeproduction()+"%");
		Predicate predicate2 = cb.like(root.get("complexityPay"),"%"+searchingCostRequest.getComplexityPay()+"%");

		return cb.or(predicate, predicate2);
		
	}

}
