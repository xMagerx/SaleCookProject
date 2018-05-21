package ua.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.entity.NameCake;
import ua.com.repository.CakeValueRepository;
import ua.com.repository.FormOfCakeRepository;
import ua.com.repository.NameCakeRepository;
import ua.com.service.NameCakeService;


@Service
public class NameCakeServiceImpl implements NameCakeService{

	@Autowired
	private NameCakeRepository nameCakeRepository;

	
	@Override
	public void save(NameCake nameCake) {
		nameCakeRepository.save(nameCake);		
	}

	@Override
	public List<NameCake> findAll() {
				return nameCakeRepository.findAll();
	}

	@Override
	public NameCake findOne(int id) {
		return nameCakeRepository.findOne(id);
	}

	@Override
	public void delete(int id) {
		nameCakeRepository.delete(id);		
	}
//
//	@Override
//	public void Filter(String name) {
//		nameCakeService.Filter(name);		
//	}

}
