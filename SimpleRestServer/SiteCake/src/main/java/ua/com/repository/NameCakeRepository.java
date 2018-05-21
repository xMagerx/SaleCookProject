package ua.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.NameCake;


public interface NameCakeRepository extends JpaRepository<NameCake, Integer>{


//	void Filter(String name);
}
