package ua.com.service;

import java.util.List;

import ua.com.entity.Cakestorage;


public interface CakestorageService {
	void save(Cakestorage cakestorage,int idRecipes);

	public List<Cakestorage> findAll();

	public Cakestorage findOne(int id);

	public void delete(int id);

//	void Filter(String ingridient,String amount);
}
