package ua.com.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import ua.com.editor.CakeValueEditor;
import ua.com.editor.FormOfCakeEditor;
import ua.com.editor.NameCakeEditor;
import ua.com.entity.CakeValue;
import ua.com.entity.FormOfCake;
import ua.com.entity.NameCake;
import ua.com.entity.Person;
import ua.com.request.DeleteCakeValueRequest;
import ua.com.request.DeleteNameCakeRequest;
import ua.com.request.DeletePersonRequest;
import ua.com.request.LoginRequest;
import ua.com.service.CakeValueService;
import ua.com.service.NameCakeService;

@CrossOrigin
@RestController
@RequestMapping("/cakevalue")
public class CakeValueController {
	@Autowired
    private CakeValueService cakeValueService;
	
	@Autowired
    private NameCakeService nameCakeService;
	
	
	  @InitBinder("cakevalue")
		protected void initBinder(WebDataBinder binder) {
			binder.registerCustomEditor(NameCake.class, new NameCakeEditor(nameCakeService));

		}
	
	@PutMapping
	public void  save( CakeValue cakeValue) {
		cakeValueService.save(cakeValue);
	}
	@GetMapping
	public List<CakeValue> cakevalues(){
		return cakeValueService.findAll();
	}
	
	
	@DeleteMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean delete(@RequestBody DeleteCakeValueRequest request){
		return cakeValueService.delete(request.getId());
	}
}
