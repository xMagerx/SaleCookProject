package ua.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.entity.Consumer;


public interface ConsumerRepository extends JpaRepository<Consumer, Integer>{


	//void Filter(String  userperson,String userlastname);
}
