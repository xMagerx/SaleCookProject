package ua.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.entity.Recipes;
import ua.com.repository.PersonRepository;
import ua.com.repository.RecipesRepository;
import ua.com.service.RecipesService;

@Service
public class RecipesServiceImpl implements RecipesService{

	@Autowired
	private RecipesRepository recipesRepository;
	@Autowired
	private PersonRepository personRepository;
	
	
	@Override
	public void save(Recipes recipes) {
		recipesRepository.save(recipes);		
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
	public void delete(int id) {
		recipesRepository.delete(id);		
	}

//	@Override
//	public void Filter(String NameRecipes) {
//		recipesRepository.Filter(NameRecipes);		
//	}

}
