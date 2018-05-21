package ua.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.entity.Person;


public interface PersonRepository extends JpaRepository<Person, Integer>,JpaSpecificationExecutor<Person>{
Person findByEmail(String email);
}
