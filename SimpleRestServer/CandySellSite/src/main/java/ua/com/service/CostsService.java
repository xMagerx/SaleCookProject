package ua.com.service;

import java.util.List;

import ua.com.entity.Costs;


public interface CostsService {
	void save(Costs costs,int idCakestorage);

	public List<Costs> findAll();

	public Costs findOne(int id);

	public void delete(int id);

//	void Filter(String timeproduction,int complexityPay);
}
