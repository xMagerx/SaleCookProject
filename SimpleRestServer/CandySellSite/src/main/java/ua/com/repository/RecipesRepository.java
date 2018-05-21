package ua.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.Recipes;
import ua.com.request.SearchingRecipesRequest;


public interface RecipesRepository extends JpaRepository<Recipes, Integer>{




//	void Filter(String NameRecipes);
}
