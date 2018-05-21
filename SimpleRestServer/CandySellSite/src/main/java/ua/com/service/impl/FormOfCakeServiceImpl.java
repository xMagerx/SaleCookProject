package ua.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.entity.FormOfCake;
import ua.com.repository.FormOfCakeRepository;
import ua.com.service.FormOfCakeService;



@Service
public class FormOfCakeServiceImpl implements FormOfCakeService{
	
     @Autowired
     private FormOfCakeRepository formOfCakeRepository;
	
	@Override
	public void save(FormOfCake formOfCake) {
		formOfCakeRepository.save(formOfCake);		
	}

	@Override
	public List<FormOfCake> findAll() {
		return formOfCakeRepository.findAll();
	}

	@Override
	public FormOfCake findOne(int id) {
		return formOfCakeRepository.findOne(id);
	}

	@Override
	public boolean delete(int id) {
		formOfCakeRepository.delete(id);
		return false;		
	}

//	@Override
//	public void Filter(String formOfCake) {
//		formOfCakeRepository.Filter(formOfCake);		
//	}

}
