package ua.com.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.editor.CakestorageEditor;
import ua.com.editor.ConsumerEditor;
import ua.com.entity.Cakestorage;
import ua.com.entity.Consumer;
import ua.com.entity.FormOfCake;
import ua.com.entity.Person;
import ua.com.entity.Recipes;
import ua.com.request.DeleteCakestorateRequest;
import ua.com.request.DeleteRecipesRequest;
import ua.com.request.SearchingRecipesRequest;
import ua.com.request.SearchingRequest;
import ua.com.service.CakestorageService;
import ua.com.service.FormOfCakeService;
import ua.com.service.RecipesService;

@CrossOrigin
@RestController
@RequestMapping("/recipes")
public class RecipesController {
	@Autowired
    private RecipesService recipesService;
	
	@Autowired
    private CakestorageService cakestorageService;
	  @InitBinder("recipes")
		protected void initBinder(WebDataBinder binder) {
			binder.registerCustomEditor(Cakestorage.class, new CakestorageEditor(cakestorageService));
		}
	
//	@PutMapping
//	@PreAuthorize("hasRole('ROLE_USER')")
//	public void  save( Recipes recipes) {
//		recipesService.save(recipes);
//	}
		@PutMapping
		@PreAuthorize("hasRole('ROLE_USER')")
		public Recipes register(@RequestBody Recipes recipes) throws IOException{
			return recipesService.save(recipes);
		}
	  
	  
	@GetMapping
	public List<Recipes> rescpess(){
		return recipesService.findAll();
	}

	@PostMapping("/search")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Recipes> recipes(@RequestBody SearchingRecipesRequest searchingRecipesRequest){
		return recipesService.findAll(searchingRecipesRequest);
	}
	
	
	@DeleteMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean delete(@RequestBody DeleteRecipesRequest deleteRecipesRequest) {
		return recipesService.delete(deleteRecipesRequest.getId());
	}
}
