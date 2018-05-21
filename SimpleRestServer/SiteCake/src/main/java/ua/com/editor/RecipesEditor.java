package ua.com.editor;

import java.beans.PropertyEditorSupport;

import ua.com.entity.Costs;
import ua.com.entity.Recipes;
import ua.com.service.RecipesService;

public class RecipesEditor extends PropertyEditorSupport{

	public final RecipesService recipesService;

	public RecipesEditor(RecipesService recipesService) {
		super();
		this.recipesService = recipesService;
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Recipes recipes = recipesService.findOne(Integer.parseInt(text));
		setValue(recipes);
	}
	
}
