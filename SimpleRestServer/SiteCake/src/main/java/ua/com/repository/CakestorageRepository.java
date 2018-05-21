package ua.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.Cakestorage;


public interface CakestorageRepository extends JpaRepository<Cakestorage, Integer>{


//	void Filter(String ingridient,String amount);
}
