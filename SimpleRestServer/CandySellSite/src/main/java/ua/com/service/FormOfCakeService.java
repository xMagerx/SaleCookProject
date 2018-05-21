package ua.com.service;

import java.util.List;

import ua.com.entity.FormOfCake;


public interface FormOfCakeService {
	void save(FormOfCake formOfCake);

	public List<FormOfCake> findAll();

	public FormOfCake findOne(int id);

	public boolean delete(int id);

//	void Filter(String formOfCake);
}
