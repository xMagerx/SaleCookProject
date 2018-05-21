package ua.com.service;

import java.util.List;

import ua.com.entity.Recipes;
import ua.com.request.SearchingRecipesRequest;


public interface RecipesService {
	Recipes save(Recipes recipes);

	public List<Recipes> findAll();

	public Recipes findOne(int id);

	public boolean delete(int id);

	List<Recipes> findAll(SearchingRecipesRequest searchingRecipesRequest);


//	void Filter(String NameRecipes);
}
