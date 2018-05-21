package ua.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.CakeValue;


public interface CakeValueRepository extends JpaRepository<CakeValue, Integer>{

//	void Filter(String V);
}
