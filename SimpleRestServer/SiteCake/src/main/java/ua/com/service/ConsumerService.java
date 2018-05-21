package ua.com.service;

import java.util.List;

import ua.com.entity.Consumer;


public interface ConsumerService {
	void save(Consumer consumer);

	public List<Consumer> findAll();

	public Consumer findOne(int id);

	public void delete(int id);

//	void Filter(String  userperson,String userlastname);
}
