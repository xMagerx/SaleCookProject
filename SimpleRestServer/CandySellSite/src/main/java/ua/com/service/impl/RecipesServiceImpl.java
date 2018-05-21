package ua.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.entity.Person;
import ua.com.entity.Recipes;
import ua.com.repository.PersonRepository;
import ua.com.repository.RecipesRepository;
import ua.com.request.SearchingRecipesRequest;
import ua.com.request.SearchingRequest;
import ua.com.service.RecipesService;
import ua.com.specification.SearchingPerson;
import ua.com.specification.SearchingRecipes;

@Service
public class RecipesServiceImpl implements RecipesService{

	@Autowired
	private RecipesRepository recipesRepository;
	@Autowired
	private PersonRepository personRepository;
	
	
	@Override
	public Recipes save(Recipes recipes) {
		return recipesRepository.save(recipes);		
	}

	@Override
	public List<Recipes> findAll() {
		return recipesRepository.findAll();
	}

	@Override
	public Recipes findOne(int id) {
		return recipesRepository.findOne(id);
	}

	@Override
	public boolean delete(int id) {
		recipesRepository.delete(id);
		return false;		
	}

	@Override
	public List<Recipes> findAll(SearchingRecipesRequest searchingRecipesRequest) {
		SearchingRecipes searchingPerson = new SearchingRecipes(searchingRecipesRequest);
		return recipesRepository.findAll();
	}

//	@Override
//	public void Filter(String NameRecipes) {
//		recipesRepository.Filter(NameRecipes);		
//	}

}
