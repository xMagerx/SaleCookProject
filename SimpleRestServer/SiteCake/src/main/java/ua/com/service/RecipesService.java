package ua.com.service;

import java.util.List;

import ua.com.entity.Recipes;


public interface RecipesService {
	void save(Recipes recipes);

	public List<Recipes> findAll();

	public Recipes findOne(int id);

	public void delete(int id);


//	void Filter(String NameRecipes);
}
