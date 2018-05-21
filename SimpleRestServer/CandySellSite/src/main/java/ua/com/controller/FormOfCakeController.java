package ua.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.editor.ConsumerEditor;
import ua.com.editor.NameCakeEditor;
import ua.com.entity.CakeValue;
import ua.com.entity.Consumer;
import ua.com.entity.FormOfCake;
import ua.com.entity.NameCake;
import ua.com.request.DeleteNameCakeRequest;
import ua.com.request.DeletePersonRequest;
import ua.com.service.CakeValueService;
import ua.com.service.FormOfCakeService;
import ua.com.service.NameCakeService;

@CrossOrigin
@RestController
@RequestMapping("/form")
public class FormOfCakeController {
	@Autowired
    private FormOfCakeService formOfCakeService;
	@Autowired
    private NameCakeService nameCakeService;
	  @InitBinder("form")
		protected void initBinder(WebDataBinder binder) {
			binder.registerCustomEditor(NameCake.class, new NameCakeEditor(nameCakeService));
		}
	
	@PutMapping
	public void  save( FormOfCake formOfCake) {
		formOfCakeService.save(formOfCake);
	}
	@GetMapping
	public List<FormOfCake> formofcakes(){
		return formOfCakeService.findAll();
	}
	
	
	@DeleteMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean delete(@RequestBody DeleteNameCakeRequest request){
		return formOfCakeService.delete(request.getId());
	}
}
