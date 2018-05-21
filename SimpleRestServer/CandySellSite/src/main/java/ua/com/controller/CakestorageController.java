package ua.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.editor.ConsumerEditor;
import ua.com.editor.RecipesEditor;
import ua.com.entity.Cakestorage;
import ua.com.entity.Consumer;
import ua.com.entity.Recipes;
import ua.com.request.DeleteCakestorateRequest;
import ua.com.request.DeleteRecipesRequest;
import ua.com.service.CakestorageService;
import ua.com.service.RecipesService;

@CrossOrigin
@RestController
@RequestMapping("/storage")
public class CakestorageController {
	@Autowired
    private CakestorageService cakestorageService;
	
	@Autowired
    private RecipesService recipesService;
	
	  @InitBinder("storage")
		protected void initBinder(WebDataBinder binder) {
			binder.registerCustomEditor(Recipes.class, new RecipesEditor(recipesService));
		}
	
	@PutMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public void  save( Cakestorage cakestorage) {
		cakestorageService.save(cakestorage);
	}
	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Cakestorage> rescpess(){
		return cakestorageService.findAll();
	}
	
	
	@DeleteMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean delete(@RequestBody DeleteCakestorateRequest deleteCakestorateRequest) {
		return cakestorageService.delete(deleteCakestorateRequest.getId());
	}
}
