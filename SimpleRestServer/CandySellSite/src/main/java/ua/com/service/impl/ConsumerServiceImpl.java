package ua.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.entity.Consumer;
import ua.com.repository.ConsumerRepository;
import ua.com.service.ConsumerService;


@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Autowired 
	private ConsumerRepository consumerRepository;
	
	
	public void save(Consumer consumer) {
		consumerRepository.save(consumer);		
	}

	@Override
	public List<Consumer> findAll() {
		return consumerRepository.findAll();
	}

	@Override
	public Consumer findOne(int id) {
		return consumerRepository.findOne(id);
	}

	@Override
	public boolean delete(int id) {
		consumerRepository.delete(id);
		return true;		
	}

//	@Override
//	public void Filter(String userperson, String userlastname) {
//		consumerRepository.Filter(userperson, userlastname);		
//	}

}
