package ua.com.service;

import java.util.List;

import ua.com.entity.Delivery;


public interface DeliveryService {
	void save(Delivery delivery);

	public List<Delivery> findAll();

	public Delivery findOne(int id);

	public void delete(int id);

//	void Filter(String delivery);
}
