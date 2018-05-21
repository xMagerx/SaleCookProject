package ua.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.entity.Costs;
import ua.com.repository.CakestorageRepository;
import ua.com.repository.CostsRepository;
import ua.com.service.CostsService;


@Service
public class CostsServiceImpl implements CostsService{

	@Autowired
	private CostsRepository costsRepository;
	@Autowired
	private CakestorageRepository cakestorageRepository;
	@Override
	public void save(Costs costs, int idCakestorage) {
		costsRepository.save(costs);		
	}

	@Override
	public List<Costs> findAll() {
		return costsRepository.findAll();
	}

	@Override
	public Costs findOne(int id) {
		return costsRepository.findOne(id);
	}

	@Override
	public void delete(int id) {
		costsRepository.delete(id);
		
	}

//	@Override
//	public void Filter(String timeproduction, int complexityPay) {
//		costsRepository.Filter(timeproduction, complexityPay);		
//	}

}
