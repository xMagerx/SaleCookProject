package ua.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.entity.CakeValue;
import ua.com.repository.CakeValueRepository;
import ua.com.service.CakeValueService;


@Service
public class CakeValueServiceImpl implements CakeValueService{

	@Autowired
	private CakeValueRepository cakeValueRepository;
	
	@Override
	public void save(CakeValue cakeValue) {
		cakeValueRepository.save(cakeValue);
		
	}

	@Override
	public List<CakeValue> findAll() {
		return cakeValueRepository.findAll();
	}

	@Override
	public CakeValue findOne(int id) {
		return cakeValueRepository.findOne(id);
	}
	@Override
	public boolean delete(int id) {
		cakeValueRepository.delete(id);
		return false;
		
	}

//	@Override
//	public void Filter(String V) {
//		cakeValueRepository.Filter(V);
//		
//	}





}
