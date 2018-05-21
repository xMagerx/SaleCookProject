package ua.com.service;

import java.util.List;

import ua.com.entity.CakeValue;


public interface CakeValueService {
	void save(CakeValue cakeValue);

	public List<CakeValue> findAll();

	public CakeValue findOne(int id);

	public boolean delete(int id);

//	void Filter(String V);
}
