package ua.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.entity.Cakestorage;
import ua.com.repository.CakestorageRepository;
import ua.com.repository.RecipesRepository;
import ua.com.service.CakestorageService;



@Service
public class CakestorageServiceImpl implements CakestorageService{

	@Autowired
	private CakestorageRepository cakestorageRepository;
	@Autowired
	private RecipesRepository recipesRepository;
	
	public void save(Cakestorage cakestorage, int idRecipes) {
		cakestorageRepository.save(cakestorage);
		
	}

	
	public List<Cakestorage> findAll() {
		return cakestorageRepository.findAll();
	}

	
	public Cakestorage findOne(int id) {
		return cakestorageRepository.findOne(id);
	}

	public void delete(int id) {
		cakestorageRepository.delete(id);
		
	}

	
//	public void Filter(String ingridient, String amount) {
//		cakestorageRepository.Filter(ingridient, amount);
//		
//	}




}
