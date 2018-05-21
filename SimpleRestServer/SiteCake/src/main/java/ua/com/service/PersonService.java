package ua.com.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;

import ua.com.entity.Person;
import ua.com.request.LoginRequest;
import ua.com.request.MyPageRequest;
import ua.com.request.SearchingRequest;
import ua.com.response.PersonResponse;


public interface PersonService {
	Person register(Person person) throws IOException;
	
	boolean login(LoginRequest loginRequest);
	
	Page<PersonResponse> findAll(MyPageRequest page);
	
	List<Person> findAll(SearchingRequest searchingRequest);
	
	boolean delete(Integer id);
}
