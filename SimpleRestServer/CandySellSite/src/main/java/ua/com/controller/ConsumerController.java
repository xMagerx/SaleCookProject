package ua.com.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.editor.PersonEditor;
import ua.com.entity.Consumer;
import ua.com.entity.Person;
import ua.com.request.DeleteConsumerRequest;
import ua.com.request.DeletePersonRequest;
import ua.com.request.LoginRequest;
import ua.com.request.MyPageRequest;
import ua.com.request.SearchingRequest;
import ua.com.response.PersonResponse;
import ua.com.service.ConsumerService;
import ua.com.service.PersonService;

@CrossOrigin
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	
	  @Autowired
	 private ConsumerService consumerService;
	
	  @Autowired
		 private PersonService personService;
    
	  @InitBinder("consumer")
		protected void initBinder(WebDataBinder binder) {
			binder.registerCustomEditor(Person.class, new PersonEditor(personService));
		}
		
	  
	  
	@PutMapping
	public void save(Consumer consumer) {
		consumerService.save(consumer);		
	}

	@DeleteMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean delete(@RequestBody DeleteConsumerRequest request){
		return consumerService.delete(request.getId());

}

	


}

	
	
