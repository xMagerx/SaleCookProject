package ua.com.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.entity.Person;
import ua.com.entity.Recipes;
import ua.com.request.SearchingRecipesRequest;
import ua.com.request.SearchingRequest;

public class SearchingRecipes implements Specification<Recipes>{
	
	private SearchingRecipesRequest searchingRecipesRequest;
	
	public SearchingRecipes(SearchingRecipesRequest searchingRecipesRequest) {
		this.searchingRecipesRequest = searchingRecipesRequest;
	}

	@Override
	public Predicate toPredicate(Root<Recipes> rootRecipesn, CriteriaQuery<?> crq, CriteriaBuilder crb) {
		CriteriaBuilder cb = crb;
		CriteriaQuery<?> cq =crq;
		Root<Recipes> root=  rootRecipesn;
		Predicate predicate = cb.like(root.get("email"),"%"+searchingRecipesRequest.getNameRecipes()+"%");
		return predicate;
		
	}
	

}
