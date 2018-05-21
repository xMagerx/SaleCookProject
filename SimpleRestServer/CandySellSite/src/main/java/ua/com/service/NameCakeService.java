package ua.com.service;

import java.util.List;

import ua.com.entity.NameCake;



public interface NameCakeService {
	NameCake save(NameCake nameCake);

	public List<NameCake> findAll();

	public NameCake findOne(int id);

	public boolean delete(int id);

//	void Filter(String name);
}
