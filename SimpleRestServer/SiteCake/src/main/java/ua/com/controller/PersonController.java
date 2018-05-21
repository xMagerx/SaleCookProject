package ua.com.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ua.com.entity.Person;
import ua.com.request.DeletePersonRequest;
import ua.com.request.LoginRequest;
import ua.com.request.MyPageRequest;
import ua.com.request.SearchingRequest;
import ua.com.response.PersonResponse;
import ua.com.service.PersonService;


@CrossOrigin
@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping("/page")
	@PreAuthorize("hasRole('ROLE_USER')")
	public Page<PersonResponse> users(@RequestBody MyPageRequest myPageRequest){
		return personService.findAll(myPageRequest);
	}

	@PostMapping("/search")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Person> users(@RequestBody SearchingRequest searchingRequest){
		return personService.findAll(searchingRequest);
	}
	
	@PutMapping
	public Person register(@RequestBody Person person) throws IOException{
		return personService.register(person);
	}
	
	@PostMapping
	public boolean login(@RequestBody LoginRequest loginRequest){
		return personService.login(loginRequest);
	}
	
	@DeleteMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean delete(@RequestBody DeletePersonRequest request){
		return personService.delete(request.getId());
	}
}
