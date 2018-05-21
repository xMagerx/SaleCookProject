package ua.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.entity.CakeValue;
import ua.com.entity.FormOfCake;
import ua.com.entity.Recipes;
import ua.com.service.RecipesService;

@Controller
public class RecipesController {
@Autowired
private RecipesService recipesService;

@RequestMapping(value="/recipes",method = RequestMethod.GET)
public String saveValue(Model model){
	model.addAttribute("recipes", new Recipes());
	return "recipes";
}

@RequestMapping(value="/recipes/save",method = RequestMethod.POST)
public String save(@ModelAttribute Recipes recipes) throws Exception{
	recipesService.save(recipes);
	return "redirect:/recipes";
}
}
