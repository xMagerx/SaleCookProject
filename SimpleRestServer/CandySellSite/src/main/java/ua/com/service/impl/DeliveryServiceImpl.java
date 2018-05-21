package ua.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.entity.Delivery;
import ua.com.repository.DeliveryRepository;
import ua.com.repository.PersonRepository;
import ua.com.service.DeliveryService;


@Service
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	private DeliveryRepository deliveryRepository;
	@Autowired
	private PersonRepository personRepository;
	@Override
	public void save(Delivery delivery) {
		deliveryRepository.save(delivery);		
	}

	@Override
	public List<Delivery> findAll() {
		return deliveryRepository.findAll();
	}

	@Override
	public Delivery findOne(int id) {
		return deliveryRepository.findOne(id);
	}

	@Override
	public void delete(int id) {
		deliveryRepository.delete(id);		
	}

//	@Override
//	public void Filter(String delivery) {
//		deliveryRepository.Filter(delivery);		
//	}

}
