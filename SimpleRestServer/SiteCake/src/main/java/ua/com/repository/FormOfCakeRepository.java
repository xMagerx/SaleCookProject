package ua.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.FormOfCake;



public interface FormOfCakeRepository extends JpaRepository<FormOfCake, Integer>{


//	void Filter(String formOfCake);
}
