package ua.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.Recipes;


public interface RecipesRepository extends JpaRepository<Recipes, Integer>{


//	void Filter(String NameRecipes);
}
