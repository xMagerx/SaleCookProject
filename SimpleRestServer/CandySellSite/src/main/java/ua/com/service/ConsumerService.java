package ua.com.service;

import java.io.IOException;
import java.util.List;

import ua.com.entity.Consumer;
import ua.com.request.LoginRequest;


public interface ConsumerService {
	void save(Consumer consumer);

	public List<Consumer> findAll();

	public Consumer findOne(int id);

	public boolean delete(int id);


//	void Filter(String  userperson,String userlastname);
}
